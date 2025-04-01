package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.FangjianEntity;

import com.service.FangjianService;
import com.entity.view.FangjianView;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 房间
 * 后端接口
 * @author
 * @email
 * @date 2021-04-27
*/
@RestController
@Controller
@RequestMapping("/fangjian")
public class FangjianController {
    private static final Logger logger = LoggerFactory.getLogger(FangjianController.class);

    @Autowired
    private FangjianService fangjianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = fangjianService.queryPage(params);

        //字典表数据转换
        List<FangjianView> list =(List<FangjianView>)page.getList();
        for(FangjianView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangjianEntity fangjian = fangjianService.selectById(id);
        if(fangjian !=null){
            //entity转view
            FangjianView view = new FangjianView();
            BeanUtils.copyProperties( fangjian , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(fangjian.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianEntity fangjian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangjian:{}",this.getClass().getName(),fangjian.toString());
        Wrapper<FangjianEntity> queryWrapper = new EntityWrapper<FangjianEntity>()
            .eq("building", fangjian.getBuilding())
            .eq("unit", fangjian.getUnit())
            .eq("room", fangjian.getRoom())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianEntity fangjianEntity = fangjianService.selectOne(queryWrapper);
        if(fangjianEntity==null){
            fangjian.setInsertTime(new Date());
            fangjian.setCreateTime(new Date());
            fangjianService.insert(fangjian);
            return R.ok();
        }else {
            return R.error(511,"房间已经被使用了");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangjianEntity fangjian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangjian:{}",this.getClass().getName(),fangjian.toString());
        //根据字段查询是否有相同数据
        Wrapper<FangjianEntity> queryWrapper = new EntityWrapper<FangjianEntity>()
            .notIn("id",fangjian.getId())
            .andNew()
            .eq("building", fangjian.getBuilding())
            .eq("unit", fangjian.getUnit())
            .eq("room", fangjian.getRoom())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianEntity fangjianEntity = fangjianService.selectOne(queryWrapper);
        if(fangjianEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fangjian.set
            //  }
            fangjianService.updateById(fangjian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"房间已经被使用了");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

