
package com.dream.common.exception.user;

/**
 * User: xiaorui.lu
 * Date: 2013年12月15日 下午9:19:00
 */
public class UserPasswordNotMatchException extends UserException {

  public UserPasswordNotMatchException() {
      super("user.password.not.match", null);
  }
}

