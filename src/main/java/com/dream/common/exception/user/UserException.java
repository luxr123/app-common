
package com.dream.common.exception.user;

import com.dream.common.exception.BaseException;


/**
 * User: xiaorui.lu
 * Date: 2013年12月15日 下午9:15:44
 */
public class UserException extends BaseException {

  public UserException(String code, Object[] args) {
      super("user", code, args, null);
  }

}

