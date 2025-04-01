package com.entity.model;

import com.entity.ShoufeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-27
 */
public class ShoufeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 收费名字
     */
    private String shoufeiName;


    /**
     * 收费类型
     */
    private Integer shoufeiTypes;


    /**
     * 预收金额
     */
    private Double shoufeiYuMonry;


    /**
     * 实收金额
     */
    private Double shoufeiShiMonry;


    /**
     * 收费备注
     */
    private String shoufeiContent;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：收费名字
	 */
    public String getShoufeiName() {
        return shoufeiName;
    }


    /**
	 * 设置：收费名字
	 */
    public void setShoufeiName(String shoufeiName) {
        this.shoufeiName = shoufeiName;
    }
    /**
	 * 获取：收费类型
	 */
    public Integer getShoufeiTypes() {
        return shoufeiTypes;
    }


    /**
	 * 设置：收费类型
	 */
    public void setShoufeiTypes(Integer shoufeiTypes) {
        this.shoufeiTypes = shoufeiTypes;
    }
    /**
	 * 获取：预收金额
	 */
    public Double getShoufeiYuMonry() {
        return shoufeiYuMonry;
    }


    /**
	 * 设置：预收金额
	 */
    public void setShoufeiYuMonry(Double shoufeiYuMonry) {
        this.shoufeiYuMonry = shoufeiYuMonry;
    }
    /**
	 * 获取：实收金额
	 */
    public Double getShoufeiShiMonry() {
        return shoufeiShiMonry;
    }


    /**
	 * 设置：实收金额
	 */
    public void setShoufeiShiMonry(Double shoufeiShiMonry) {
        this.shoufeiShiMonry = shoufeiShiMonry;
    }
    /**
	 * 获取：收费备注
	 */
    public String getShoufeiContent() {
        return shoufeiContent;
    }


    /**
	 * 设置：收费备注
	 */
    public void setShoufeiContent(String shoufeiContent) {
        this.shoufeiContent = shoufeiContent;
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
