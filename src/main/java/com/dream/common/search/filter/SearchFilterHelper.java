
package com.dream.common.search.filter;

import com.dream.common.search.exception.SearchException;

/**
 * User: xiaorui.lu
 * Date: 2013年12月18日 下午9:06:54
 */
public final class SearchFilterHelper {

  /**
   * 根据查询key和值生成Condition
   *
   * @param key   如 name_like
   * @param value
   * @return
   */
  public static SearchFilter newCondition(final String key, final Object value) throws SearchException {
      return Condition.newCondition(key, value);
  }
}

