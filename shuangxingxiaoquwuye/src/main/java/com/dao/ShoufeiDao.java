package com.dao;

import com.entity.ShoufeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShoufeiView;

/**
 * 收费 Dao 接口
 *
 * @author 
 * @since 2021-04-27
 */
public interface ShoufeiDao extends BaseMapper<ShoufeiEntity> {

   List<ShoufeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
