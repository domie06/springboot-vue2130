package com.dao;

import com.entity.SheshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SheshiView;

/**
 * 设施 Dao 接口
 *
 * @author 
 * @since 2021-04-27
 */
public interface SheshiDao extends BaseMapper<SheshiEntity> {

   List<SheshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
