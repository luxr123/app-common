
package com.dream.common.search.exception;


/**
 * User: xiaorui.lu
 * Date: 2013年12月18日 下午9:23:03
 */
public final class InvalidSearchPropertyException extends SearchException {

  public InvalidSearchPropertyException(String searchProperty, String entityProperty) {
      this(searchProperty, entityProperty, null);
  }

  public InvalidSearchPropertyException(String searchProperty, String entityProperty, Throwable cause) {
      super("Invalid Search Property [" + searchProperty + "] Entity Property [" + entityProperty + "]", cause);
  }


}

