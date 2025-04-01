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

import com.entity.SheshiEntity;

import com.service.SheshiService;
import com.entity.view.SheshiView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 设施
 * 后端接口
 * @author
 * @email
 * @date 2021-04-27
*/
@RestController
@Controller
@RequestMapping("/sheshi")
public class SheshiController {
    private static final Logger logger = LoggerFactory.getLogger(SheshiController.class);

    @Autowired
    private SheshiService sheshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service


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
        PageUtils page = sheshiService.queryPage(params);

        //字典表数据转换
        List<SheshiView> list =(List<SheshiView>)page.getList();
        for(SheshiView c:list){
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
        SheshiEntity sheshi = sheshiService.selectById(id);
        if(sheshi !=null){
            //entity转view
            SheshiView view = new SheshiView();
            BeanUtils.copyProperties( sheshi , view );//把实体数据重构到view中

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
    public R save(@RequestBody SheshiEntity sheshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,sheshi:{}",this.getClass().getName(),sheshi.toString());
        Wrapper<SheshiEntity> queryWrapper = new EntityWrapper<SheshiEntity>()
            .eq("sheshi_number", sheshi.getSheshiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SheshiEntity sheshiEntity = sheshiService.selectOne(queryWrapper);
        if(sheshiEntity==null){
            sheshi.setInsertTime(new Date());
            sheshi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      sheshi.set
        //  }
            sheshiService.insert(sheshi);
            return R.ok();
        }else {
            return R.error(511,"设施编号被使用了");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SheshiEntity sheshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,sheshi:{}",this.getClass().getName(),sheshi.toString());
        //根据字段查询是否有相同数据
        Wrapper<SheshiEntity> queryWrapper = new EntityWrapper<SheshiEntity>()
            .notIn("id",sheshi.getId())
            .andNew()
            .eq("sheshi_number", sheshi.getSheshiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SheshiEntity sheshiEntity = sheshiService.selectOne(queryWrapper);
        if(sheshiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      sheshi.set
            //  }
            sheshiService.updateById(sheshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"设施编号被使用了");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        sheshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

