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
 * 收费
 *
 * @author 
 * @email
 * @date 2021-04-27
 */
@TableName("shoufei")
public class ShoufeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShoufeiEntity() {

	}

	public ShoufeiEntity(T t) {
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
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 收费名字
     */
    @TableField(value = "shoufei_name")

    private String shoufeiName;


    /**
     * 收费类型
     */
    @TableField(value = "shoufei_types")

    private Integer shoufeiTypes;


    /**
     * 预收金额
     */
    @TableField(value = "shoufei_yu_monry")

    private Double shoufeiYuMonry;


    /**
     * 实收金额
     */
    @TableField(value = "shoufei_shi_monry")

    private Double shoufeiShiMonry;


    /**
     * 收费备注
     */
    @TableField(value = "shoufei_content")

    private String shoufeiContent;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：收费名字
	 */
    public String getShoufeiName() {
        return shoufeiName;
    }


    /**
	 * 获取：收费名字
	 */

    public void setShoufeiName(String shoufeiName) {
        this.shoufeiName = shoufeiName;
    }
    /**
	 * 设置：收费类型
	 */
    public Integer getShoufeiTypes() {
        return shoufeiTypes;
    }


    /**
	 * 获取：收费类型
	 */

    public void setShoufeiTypes(Integer shoufeiTypes) {
        this.shoufeiTypes = shoufeiTypes;
    }
    /**
	 * 设置：预收金额
	 */
    public Double getShoufeiYuMonry() {
        return shoufeiYuMonry;
    }


    /**
	 * 获取：预收金额
	 */

    public void setShoufeiYuMonry(Double shoufeiYuMonry) {
        this.shoufeiYuMonry = shoufeiYuMonry;
    }
    /**
	 * 设置：实收金额
	 */
    public Double getShoufeiShiMonry() {
        return shoufeiShiMonry;
    }


    /**
	 * 获取：实收金额
	 */

    public void setShoufeiShiMonry(Double shoufeiShiMonry) {
        this.shoufeiShiMonry = shoufeiShiMonry;
    }
    /**
	 * 设置：收费备注
	 */
    public String getShoufeiContent() {
        return shoufeiContent;
    }


    /**
	 * 获取：收费备注
	 */

    public void setShoufeiContent(String shoufeiContent) {
        this.shoufeiContent = shoufeiContent;
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
        return "Shoufei{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", shoufeiName=" + shoufeiName +
            ", shoufeiTypes=" + shoufeiTypes +
            ", shoufeiYuMonry=" + shoufeiYuMonry +
            ", shoufeiShiMonry=" + shoufeiShiMonry +
            ", shoufeiContent=" + shoufeiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
