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

import com.entity.LiuyanbanEntity;

import com.service.LiuyanbanService;
import com.entity.view.LiuyanbanView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 留言板
 * 后端接口
 * @author
 * @email
 * @date 2021-04-27
*/
@RestController
@Controller
@RequestMapping("/liuyanban")
public class LiuyanbanController {
    private static final Logger logger = LoggerFactory.getLogger(LiuyanbanController.class);

    @Autowired
    private LiuyanbanService liuyanbanService;


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
        PageUtils page = liuyanbanService.queryPage(params);

        //字典表数据转换
        List<LiuyanbanView> list =(List<LiuyanbanView>)page.getList();
        for(LiuyanbanView c:list){
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
        LiuyanbanEntity liuyanban = liuyanbanService.selectById(id);
        if(liuyanban !=null){
            //entity转view
            LiuyanbanView view = new LiuyanbanView();
            BeanUtils.copyProperties( liuyanban , view );//把实体数据重构到view中

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
    public R save(@RequestBody LiuyanbanEntity liuyanban, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liuyanban:{}",this.getClass().getName(),liuyanban.toString());
        Wrapper<LiuyanbanEntity> queryWrapper = new EntityWrapper<LiuyanbanEntity>()
            .eq("liuyanban_name", liuyanban.getLiuyanbanName())
            .eq("liuiyan_types", liuyanban.getLiuiyanTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiuyanbanEntity liuyanbanEntity = liuyanbanService.selectOne(queryWrapper);
        if(liuyanbanEntity==null){
            liuyanban.setInsertTime(new Date());
            liuyanban.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      liuyanban.set
        //  }
            liuyanbanService.insert(liuyanban);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiuyanbanEntity liuyanban, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,liuyanban:{}",this.getClass().getName(),liuyanban.toString());
        //根据字段查询是否有相同数据
        Wrapper<LiuyanbanEntity> queryWrapper = new EntityWrapper<LiuyanbanEntity>()
            .notIn("id",liuyanban.getId())
            .andNew()
            .eq("liuyanban_name", liuyanban.getLiuyanbanName())
            .eq("liuiyan_types", liuyanban.getLiuiyanTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiuyanbanEntity liuyanbanEntity = liuyanbanService.selectOne(queryWrapper);
        if(liuyanbanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      liuyanban.set
            //  }
            liuyanbanService.updateById(liuyanban);//根据id更新
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
        liuyanbanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

