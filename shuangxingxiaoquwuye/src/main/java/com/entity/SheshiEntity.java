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
 * 设施
 *
 * @author 
 * @email
 * @date 2021-04-27
 */
@TableName("sheshi")
public class SheshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SheshiEntity() {

	}

	public SheshiEntity(T t) {
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
     * 设施名字
     */
    @TableField(value = "sheshi_name")

    private String sheshiName;


    /**
     * 设施编号
     */
    @TableField(value = "sheshi_number")

    private String sheshiNumber;


    /**
     * 设施类型
     */
    @TableField(value = "sheshi_types")

    private Integer sheshiTypes;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "sheshi_time",fill = FieldFill.UPDATE)

    private Date sheshiTime;


    /**
     * 购买价格
     */
    @TableField(value = "sheshi_monry")

    private Double sheshiMonry;


    /**
     * 设施备注
     */
    @TableField(value = "sheshi_content")

    private String sheshiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：设施名字
	 */
    public String getSheshiName() {
        return sheshiName;
    }


    /**
	 * 获取：设施名字
	 */

    public void setSheshiName(String sheshiName) {
        this.sheshiName = sheshiName;
    }
    /**
	 * 设置：设施编号
	 */
    public String getSheshiNumber() {
        return sheshiNumber;
    }


    /**
	 * 获取：设施编号
	 */

    public void setSheshiNumber(String sheshiNumber) {
        this.sheshiNumber = sheshiNumber;
    }
    /**
	 * 设置：设施类型
	 */
    public Integer getSheshiTypes() {
        return sheshiTypes;
    }


    /**
	 * 获取：设施类型
	 */

    public void setSheshiTypes(Integer sheshiTypes) {
        this.sheshiTypes = sheshiTypes;
    }
    /**
	 * 设置：购买时间
	 */
    public Date getSheshiTime() {
        return sheshiTime;
    }


    /**
	 * 获取：购买时间
	 */

    public void setSheshiTime(Date sheshiTime) {
        this.sheshiTime = sheshiTime;
    }
    /**
	 * 设置：购买价格
	 */
    public Double getSheshiMonry() {
        return sheshiMonry;
    }


    /**
	 * 获取：购买价格
	 */

    public void setSheshiMonry(Double sheshiMonry) {
        this.sheshiMonry = sheshiMonry;
    }
    /**
	 * 设置：设施备注
	 */
    public String getSheshiContent() {
        return sheshiContent;
    }


    /**
	 * 获取：设施备注
	 */

    public void setSheshiContent(String sheshiContent) {
        this.sheshiContent = sheshiContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Sheshi{" +
            "id=" + id +
            ", sheshiName=" + sheshiName +
            ", sheshiNumber=" + sheshiNumber +
            ", sheshiTypes=" + sheshiTypes +
            ", sheshiTime=" + sheshiTime +
            ", sheshiMonry=" + sheshiMonry +
            ", sheshiContent=" + sheshiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
