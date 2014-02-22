
package com.dream.common.search.exception;

import com.dream.common.search.SearchOperator;


/**
 * User: xiaorui.lu
 * Date: 2013年12月18日 下午9:12:35
 */
public final class InvlidSearchOperatorException extends SearchException {

  public InvlidSearchOperatorException(String searchProperty, String operatorStr) {
      this(searchProperty, operatorStr, null);
  }

  public InvlidSearchOperatorException(String searchProperty, String operatorStr, Throwable cause) {
      super("Invalid Search Operator searchProperty [" + searchProperty + "], " +
              "operator [" + operatorStr + "], must be one of " + SearchOperator.toStringAllOperator(), cause);
  }
}

