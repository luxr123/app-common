
package com.dream.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * User: xiaorui.lu
 * Date: 2013年12月25日 下午8:42:49
 */
@Entity
@Table(name = "undotask")
public class undotask extends BaseEntity<Long> {

	@Column(name = "freshtaskid")
	private long freshtaskid;// 被选择的任务的键值

	@Column(name = "userpos")
	@Enumerated(EnumType.STRING)
	private UserPosition userpos;// 创建用户id/领取了任务但等待被发布任务者确认的候选用户id(好处是可以存多个candidateuserid)

	@Column(name = "userposid")
	private long userposid;// 创建用户/领取了任务但等待被发布任务者确认的候选用户的id

	@Column(name = "receivecount")
	private long receivecount;// 该任务已经被领取的人数(每领取一人+1,主要是减轻前端的负载)

	public long getFreshtaskid() {
		return freshtaskid;
	}

	public void setFreshtaskid(long freshtaskid) {
		this.freshtaskid = freshtaskid;
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

	public long getReceivecount() {
		return receivecount;
	}

	public void setReceivecount(long receivecount) {
		this.receivecount = receivecount;
	}
	
}

