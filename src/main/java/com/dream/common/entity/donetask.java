
package com.dream.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * User: xiaorui.lu
 * Date: 2013年12月25日 下午8:54:03
 */
@Entity
@Table(name = "donetask")
public class donetask extends BaseEntity<Long> {

	@Column(name = "content")
	private String content; // 任务内容

	@Column(name = "imgurl")
	private String imgurl; // 任务图片地址，多张图片通过‘；’隔开

	@Column(name = "contactinfo")
	private String contactinfo; // 联系信息，只有被确认的用户才能看到

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "createtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime; // 任务发布时间

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "endtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endtime;// 任务结束时间（从任务发布到任务结束这段时间是用户规定的时效）

	@Column(name = "userpos")
	@Enumerated(EnumType.STRING)
	private UserPosition userpos;// 创建用户\接受用户

	@Column(name = "userposid")
	private long userposid;// 发布/接受该任务的用户键值(注:最终成功领取者唯一键值，当这一项为-1时，则代表是任务时效过了没人领取)

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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public UserPosition getUserpos() {
		return userpos;
	}

	public void setUserpos(UserPosition userpos) {
		this.userpos = userpos;
	}

	public long getUserposid() {
		return userposid;
	}

	public void setUserposid(long userposid) {
		this.userposid = userposid;
	}

}

