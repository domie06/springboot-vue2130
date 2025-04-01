package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.SheshiDao;
import com.entity.SheshiEntity;
import com.service.SheshiService;
import com.entity.view.SheshiView;

/**
 * 设施 服务实现类
 * @author 
 * @since 2021-04-27
 */
@Service("sheshiService")
@Transactional
public class SheshiServiceImpl extends ServiceImpl<SheshiDao, SheshiEntity> implements SheshiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<SheshiView> page =new Query<SheshiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
