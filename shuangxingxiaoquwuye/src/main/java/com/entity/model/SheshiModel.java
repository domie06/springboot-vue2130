package com.entity.model;

import com.entity.SheshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设施
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-27
 */
public class SheshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 设施名字
     */
    private String sheshiName;


    /**
     * 设施编号
     */
    private String sheshiNumber;


    /**
     * 设施类型
     */
    private Integer sheshiTypes;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date sheshiTime;


    /**
     * 购买价格
     */
    private Double sheshiMonry;


    /**
     * 设施备注
     */
    private String sheshiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：设施名字
	 */
    public String getSheshiName() {
        return sheshiName;
    }


    /**
	 * 设置：设施名字
	 */
    public void setSheshiName(String sheshiName) {
        this.sheshiName = sheshiName;
    }
    /**
	 * 获取：设施编号
	 */
    public String getSheshiNumber() {
        return sheshiNumber;
    }


    /**
	 * 设置：设施编号
	 */
    public void setSheshiNumber(String sheshiNumber) {
        this.sheshiNumber = sheshiNumber;
    }
    /**
	 * 获取：设施类型
	 */
    public Integer getSheshiTypes() {
        return sheshiTypes;
    }


    /**
	 * 设置：设施类型
	 */
    public void setSheshiTypes(Integer sheshiTypes) {
        this.sheshiTypes = sheshiTypes;
    }
    /**
	 * 获取：购买时间
	 */
    public Date getSheshiTime() {
        return sheshiTime;
    }


    /**
	 * 设置：购买时间
	 */
    public void setSheshiTime(Date sheshiTime) {
        this.sheshiTime = sheshiTime;
    }
    /**
	 * 获取：购买价格
	 */
    public Double getSheshiMonry() {
        return sheshiMonry;
    }


    /**
	 * 设置：购买价格
	 */
    public void setSheshiMonry(Double sheshiMonry) {
        this.sheshiMonry = sheshiMonry;
    }
    /**
	 * 获取：设施备注
	 */
    public String getSheshiContent() {
        return sheshiContent;
    }


    /**
	 * 设置：设施备注
	 */
    public void setSheshiContent(String sheshiContent) {
        this.sheshiContent = sheshiContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
