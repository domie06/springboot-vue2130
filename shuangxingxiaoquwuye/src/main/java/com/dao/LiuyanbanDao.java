package com.dao;

import com.entity.LiuyanbanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiuyanbanView;

/**
 * 留言板 Dao 接口
 *
 * @author 
 * @since 2021-04-27
 */
public interface LiuyanbanDao extends BaseMapper<LiuyanbanEntity> {

   List<LiuyanbanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
