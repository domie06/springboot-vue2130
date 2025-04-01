package com.entity.view;

import com.entity.LiuyanbanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言板
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-27
 */
@TableName("liuyanban")
public class LiuyanbanView extends LiuyanbanEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 留言类型的值
		*/
		private String liuiyanValue;



	public LiuyanbanView() {

	}

	public LiuyanbanView(LiuyanbanEntity liuyanbanEntity) {
		try {
			BeanUtils.copyProperties(this, liuyanbanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 留言类型的值
			*/
			public String getLiuiyanValue() {
				return liuiyanValue;
			}
			/**
			* 设置： 留言类型的值
			*/
			public void setLiuiyanValue(String liuiyanValue) {
				this.liuiyanValue = liuiyanValue;
			}













}
