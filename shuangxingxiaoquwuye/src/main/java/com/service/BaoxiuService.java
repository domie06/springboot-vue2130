package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaoxiuEntity;
import java.util.Map;

/**
 * 报修 服务类
 * @author 
 * @since 2021-04-27
 */
public interface BaoxiuService extends IService<BaoxiuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}