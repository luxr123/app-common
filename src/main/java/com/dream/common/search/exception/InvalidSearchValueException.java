
package com.dream.common.search.exception;


/**
 * User: xiaorui.lu
 * Date: 2013年12月18日 下午9:22:49
 */
public final class InvalidSearchValueException extends SearchException {

  public InvalidSearchValueException(String searchProperty, String entityProperty, Object value) {
      this(searchProperty, entityProperty, value, null);
  }

  public InvalidSearchValueException(String searchProperty, String entityProperty, Object value, Throwable cause) {
      super("Invalid Search Value, searchProperty [" + searchProperty + "], " +
              "entityProperty [" + entityProperty + "], value [" + value + "]", cause);
  }

}

