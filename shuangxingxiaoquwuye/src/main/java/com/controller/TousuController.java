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

import com.entity.TousuEntity;

import com.service.TousuService;
import com.entity.view.TousuView;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 投诉
 * 后端接口
 * @author
 * @email
 * @date 2021-04-27
*/
@RestController
@Controller
@RequestMapping("/tousu")
public class TousuController {
    private static final Logger logger = LoggerFactory.getLogger(TousuController.class);

    @Autowired
    private TousuService tousuService;


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
        PageUtils page = tousuService.queryPage(params);

        //字典表数据转换
        List<TousuView> list =(List<TousuView>)page.getList();
        for(TousuView c:list){
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
        TousuEntity tousu = tousuService.selectById(id);
        if(tousu !=null){
            //entity转view
            TousuView view = new TousuView();
            BeanUtils.copyProperties( tousu , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tousu.getYonghuId());
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
    public R save(@RequestBody TousuEntity tousu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tousu:{}",this.getClass().getName(),tousu.toString());
        Wrapper<TousuEntity> queryWrapper = new EntityWrapper<TousuEntity>()
            .eq("yonghu_id", tousu.getYonghuId())
            .eq("tousu_name", tousu.getTousuName())
            .eq("tousu_types", tousu.getTousuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TousuEntity tousuEntity = tousuService.selectOne(queryWrapper);
        if(tousuEntity==null){
            tousu.setInsertTime(new Date());
            tousu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      tousu.set
        //  }
            tousuService.insert(tousu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TousuEntity tousu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tousu:{}",this.getClass().getName(),tousu.toString());
        //根据字段查询是否有相同数据
        Wrapper<TousuEntity> queryWrapper = new EntityWrapper<TousuEntity>()
            .notIn("id",tousu.getId())
            .andNew()
            .eq("yonghu_id", tousu.getYonghuId())
            .eq("tousu_name", tousu.getTousuName())
            .eq("tousu_types", tousu.getTousuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TousuEntity tousuEntity = tousuService.selectOne(queryWrapper);
        tousu.setUpdateTime(new Date());
        if(tousuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      tousu.set
            //  }
            tousuService.updateById(tousu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tousuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

