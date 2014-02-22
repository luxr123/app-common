package com.dream.common.enums;

/**
 * User: xiaorui.lu 
 * Date: 2013年12月17日 下午1:43:38
 */
public enum BooleanEnum {
  TRUE(Boolean.TRUE, "是"), FALSE(Boolean.FALSE, "否");

  private final Boolean value;
  private final String info;

  private BooleanEnum(Boolean value, String info) {
    this.value = value;
    this.info = info;
  }

  public String getInfo() {
    return info;
  }

  public Boolean getValue() {
    return value;
  }
}
