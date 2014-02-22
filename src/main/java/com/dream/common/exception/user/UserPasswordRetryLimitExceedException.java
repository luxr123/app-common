
package com.dream.common.exception.user;

/**
 * User: xiaorui.lu
 * Date: 2013年12月15日 下午9:15:02
 */
public class UserPasswordRetryLimitExceedException extends UserException {
  public UserPasswordRetryLimitExceedException(int retryLimitCount) {
      super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
  }
}

