package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheshiEntity;
import java.util.Map;

/**
 * 设施 服务类
 * @author 
 * @since 2021-04-27
 */
public interface SheshiService extends IService<SheshiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}