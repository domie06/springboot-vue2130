package com.entity.model;

import com.entity.LiuyanbanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 留言板
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-27
 */
public class LiuyanbanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 留言名称
     */
    private String liuyanbanName;


    /**
     * 留言类型
     */
    private Integer liuiyanTypes;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 留言
     */
    private String liuyanbanContent;


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
	 * 获取：留言名称
	 */
    public String getLiuyanbanName() {
        return liuyanbanName;
    }


    /**
	 * 设置：留言名称
	 */
    public void setLiuyanbanName(String liuyanbanName) {
        this.liuyanbanName = liuyanbanName;
    }
    /**
	 * 获取：留言类型
	 */
    public Integer getLiuiyanTypes() {
        return liuiyanTypes;
    }


    /**
	 * 设置：留言类型
	 */
    public void setLiuiyanTypes(Integer liuiyanTypes) {
        this.liuiyanTypes = liuiyanTypes;
    }
    /**
	 * 获取：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：留言时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：留言
	 */
    public String getLiuyanbanContent() {
        return liuyanbanContent;
    }


    /**
	 * 设置：留言
	 */
    public void setLiuyanbanContent(String liuyanbanContent) {
        this.liuyanbanContent = liuyanbanContent;
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
