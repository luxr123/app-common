
package com.dream.common.exception.user;

/**
 * User: xiaorui.lu
 * Date: 2014年1月2日 下午8:55:15
 */
public class UserNotExistsException extends UserException {

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}

