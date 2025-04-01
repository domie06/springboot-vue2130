package com.entity.view;

import com.entity.SheshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 设施
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-27
 */
@TableName("sheshi")
public class SheshiView extends SheshiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 设施类型的值
		*/
		private String sheshiValue;



	public SheshiView() {

	}

	public SheshiView(SheshiEntity sheshiEntity) {
		try {
			BeanUtils.copyProperties(this, sheshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 设施类型的值
			*/
			public String getSheshiValue() {
				return sheshiValue;
			}
			/**
			* 设置： 设施类型的值
			*/
			public void setSheshiValue(String sheshiValue) {
				this.sheshiValue = sheshiValue;
			}













}
