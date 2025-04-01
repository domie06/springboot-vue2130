package com.entity.vo;

import com.entity.FangjianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-27
 */
@TableName("fangjian")
public class FangjianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 楼栋
     */

    @TableField(value = "building")
    private String building;


    /**
     * 单元
     */

    @TableField(value = "unit")
    private String unit;


    /**
     * 房间号
     */

    @TableField(value = "room")
    private String room;


    /**
     * 房间备注
     */

    @TableField(value = "fangjian_content")
    private String fangjianContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：楼栋
	 */
    public String getBuilding() {
        return building;
    }


    /**
	 * 获取：楼栋
	 */

    public void setBuilding(String building) {
        this.building = building;
    }
    /**
	 * 设置：单元
	 */
    public String getUnit() {
        return unit;
    }


    /**
	 * 获取：单元
	 */

    public void setUnit(String unit) {
        this.unit = unit;
    }
    /**
	 * 设置：房间号
	 */
    public String getRoom() {
        return room;
    }


    /**
	 * 获取：房间号
	 */

    public void setRoom(String room) {
        this.room = room;
    }
    /**
	 * 设置：房间备注
	 */
    public String getFangjianContent() {
        return fangjianContent;
    }


    /**
	 * 获取：房间备注
	 */

    public void setFangjianContent(String fangjianContent) {
        this.fangjianContent = fangjianContent;
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

}
