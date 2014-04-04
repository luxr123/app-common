package com.dream.common.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * User: xiaorui.lu Date: 2013年12月25日 下午8:36:06
 */
@Entity
@Table(name = "task")
public class UserTask extends BaseEntity<Long> implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 8677807676848873618L;

  /**
   * 
   */

  @Column(name = "content")
  private String content; // 任务内容

  @Column(name = "imgurl")
  private String imgurl; // 任务图片地址，多张图片通过‘；’隔开

  @Column(name = "contactinfo")
  private String contactinfo; // 联系信息，只有被确认的用户才能看到

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "createtime")
  private String createtime; // 任务发布时间

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "endtime")
  private String endtime; // 任务结束时间（从任务发布到任务结束这段时间是用户规定的时效）

  @Column(name = "createuserid")
  private long createuserid; // 发布该任务的用户键值

  @Column(name = "status")
  private int status; // 0：没过时；1：过时； 2：被删除
  
//不需要持久到DB的属性使用该注解
  @Transient
   private int successcount;  //成功领取该任务人数
  
//不需要持久到DB的属性使用该注解
  @Transient
   private int waitcount;  //等待领取该任务人数
  
//不需要持久到DB的属性使用该注解
  @Transient
   private String createusername;  //发布该任务的用户名
  
//不需要持久到DB的属性使用该注解
  @Transient
   private String userIcon;  //发布该任务的用户头像路径

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }

  public String getContactinfo() {
    return contactinfo;
  }

  public void setContactinfo(String contactinfo) {
    this.contactinfo = contactinfo;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }

  public long getCreateuserid() {
    return createuserid;
  }

  public void setCreateuserid(long createuserid) {
    this.createuserid = createuserid;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getSuccesscount() {
    return successcount;
  }

  
  public void setSuccesscount(int successcount) {
    this.successcount = successcount;
  }

  
  public int getWaitcount() {
    return waitcount;
  }

  
  public void setWaitcount(int waitcount) {
    this.waitcount = waitcount;
  }

  
  public String getCreateusername() {
    return createusername;
  }

  
  public void setCreateusername(String createusername) {
    this.createusername = createusername;
  }

  
  public String getUserIcon() {
    return userIcon;
  }

  
  public void setUserIcon(String userIcon) {
    this.userIcon = userIcon;
  }


}
