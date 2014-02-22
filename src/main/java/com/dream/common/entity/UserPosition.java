
package com.dream.common.entity;

/**
 * User: xiaorui.lu
 * Date: 2013年12月25日 下午8:48:28
 */
public enum UserPosition {

	createuser("createuser"), candidateuser("candidateuser");
	
	private final String info;

	private UserPosition(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
	
}

