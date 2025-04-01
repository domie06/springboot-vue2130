package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 留言板
 *
 * @author 
 * @email
 * @date 2021-04-27
 */
@TableName("liuyanban")
public class LiuyanbanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiuyanbanEntity() {

	}

	public LiuyanbanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 留言名称
     */
    @TableField(value = "liuyanban_name")

    private String liuyanbanName;


    /**
     * 留言类型
     */
    @TableField(value = "liuiyan_types")

    private Integer liuiyanTypes;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 留言
     */
    @TableField(value = "liuyanban_content")

    private String liuyanbanContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：留言名称
	 */
    public String getLiuyanbanName() {
        return liuyanbanName;
    }


    /**
	 * 获取：留言名称
	 */

    public void setLiuyanbanName(String liuyanbanName) {
        this.liuyanbanName = liuyanbanName;
    }
    /**
	 * 设置：留言类型
	 */
    public Integer getLiuiyanTypes() {
        return liuiyanTypes;
    }


    /**
	 * 获取：留言类型
	 */

    public void setLiuiyanTypes(Integer liuiyanTypes) {
        this.liuiyanTypes = liuiyanTypes;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：留言时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：留言
	 */
    public String getLiuyanbanContent() {
        return liuyanbanContent;
    }


    /**
	 * 获取：留言
	 */

    public void setLiuyanbanContent(String liuyanbanContent) {
        this.liuyanbanContent = liuyanbanContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Liuyanban{" +
            "id=" + id +
            ", liuyanbanName=" + liuyanbanName +
            ", liuiyanTypes=" + liuiyanTypes +
            ", insertTime=" + insertTime +
            ", liuyanbanContent=" + liuyanbanContent +
            ", createTime=" + createTime +
        "}";
    }
}
