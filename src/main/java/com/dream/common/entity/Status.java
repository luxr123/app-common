
package com.dream.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * User: xiaorui.lu
 * Date: 2013年12月25日 下午8:42:49
 */
@Entity
@Table(name = "status")
public class Status extends BaseEntity<Long> { 

	@Column(name = "taskid")
	private long taskid;// 被选择的任务的键值
	
	@Column(name="candidateuserid")
	private long candidateuserid;
	
	@Column(name="status")
	private int status;   //0：等待领取；1：领取成功；2：领取失败
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime; // 更新状态时间

  
  public long getTaskid() {
    return taskid;
  }

  
  public void setTaskid(long taskid) {
    this.taskid = taskid;
  }

  
  public long getCandidateuserid() {
    return candidateuserid;
  }

  
  public void setCandidateuserid(long candidateuserid) {
    this.candidateuserid = candidateuserid;
  }

  
  public int getStatus() {
    return status;
  }

  
  public void setStatus(int status) {
    this.status = status;
  }

  
  public Date getCreatetime() {
    return createtime;
  }

  
  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }
	
	


	
}

