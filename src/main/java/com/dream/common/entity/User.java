package com.dream.common.entity;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Date;

/**
 * User: xiaorui.lu 
 * Date: 2013年12月13日 下午4:10:16
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity<Long> {

	public static final String NAME_PATTERN = "^[\\u4E00-\\u9FA5\\uf900-\\ufa2d_a-zA-Z][\\u4E00-\\u9FA5\\uf900-\\ufa2d\\w]{1,19}$";
	public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 20;
	public static final int PASSWORD_MIN_LENGTH = 5;
	public static final int PASSWORD_MAX_LENGTH = 50;

	@NotNull(message = "{not.null}")
	@Pattern(regexp = NAME_PATTERN, message = "{user.name.not.valid}")
	@Column(name = "name")
	private String name;

	/**
	 * 使用md5(username + original password + salt)加密存储
	 */
	@Length(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH, message = "{user.password.not.valid}")
	@NotEmpty(message = "{not.null}")
	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private boolean role;
	
	@Column(name="udid")
	private String udid;
	
	@Column(name="tags")
	private String tags;

	@Transient
	// 不需要持久到DB的属性使用该注解
	private String checkcode;
	
	// 不需要持久到DB的属性使用该注解
	@Transient
	private String guid;
	
	
	
	@Column(columnDefinition="text")
	private String iconPath;
	
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * 加密密码时使用的种子
	 */
	private String salt;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "createtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updatetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatetime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 生成新的种子
	 */
	public void randomSalt() {
		setSalt(RandomStringUtils.randomAlphanumeric(10));
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
  public String getUdid() {
    return udid;
  }

  
  public void setUdid(String udid) {
    this.udid = udid;
  }

  
  public String getTags() {
    return tags;
  }

  
  public void setTags(String tags) {
    this.tags = tags;
  }
  

  @Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", role=" + role + ", checkcode=" + checkcode + ", guid=" + guid
				+  ", gender=" + gender + ", salt=" + salt + ", createtime=" + createtime + ", updatetime="
				+ updatetime + ", udid=" + udid +", tags=" + tags+ "]";
	}

	public static void main(String[] args) {
		User user = new User();
		user.setCheckcode("1");
		user.setGuid("2");
		user.setId(1L);
		user.setName("xx");
		user.setRole(true);
		System.out.println(user);
		System.out.println(JSON.toJSONString(user));
	}
}
