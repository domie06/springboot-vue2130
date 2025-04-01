package com.entity.vo;

import com.entity.LiuyanbanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 留言板
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-27
 */
@TableName("liuyanban")
public class LiuyanbanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

}
