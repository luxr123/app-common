
package com.dream.common.search.exception;

import org.springframework.core.NestedRuntimeException;


/**
 * User: xiaorui.lu
 * Date: 2013年12月18日 下午9:08:13
 */
public class SearchException extends NestedRuntimeException {

  public SearchException(String msg) {
      super(msg);
  }

  public SearchException(String msg, Throwable cause) {
      super(msg, cause);
  }
}

