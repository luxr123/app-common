
package com.dream.common.search;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.dream.common.search.exception.InvalidSearchPropertyException;
import com.dream.common.search.exception.InvalidSearchValueException;
import com.dream.common.search.exception.SearchException;
import com.dream.common.search.filter.Condition;
import com.dream.common.search.filter.SearchFilter;
import com.dream.common.search.filter.SearchFilterHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 查询条件（包括分页和排序）
 * User: xiaorui.lu
 * Date: 2013年12月18日 下午8:59:14
 */
public final class SearchRequest extends Searchable {

  private final Map<String, SearchFilter> searchFilterMap = Maps.newHashMap();
  /**
   * 使用这个的目的是保证拼sql的顺序是按照添加时的顺序
   */
  private final List<SearchFilter> searchFilters = Lists.newArrayList();

  private Pageable page;

  private Sort sort;

  private boolean converted;

  /**
   * @param searchParams
   * @see SearchRequest#SearchRequest(java.util.Map<java.lang.String,java.lang.Object>)
   */
  public SearchRequest(final Map<String, Object> searchParams) {
      this(searchParams, null, null);
  }

  public SearchRequest() {
      this(null, null, null);
  }

  /**
   * @param searchParams
   * @see SearchRequest#SearchRequest(java.util.Map<java.lang.String,java.lang.Object>)
   */
  public SearchRequest(final Map<String, Object> searchParams, final Pageable page) {
      this(searchParams, page, null);
  }

  /**
   * @param searchParams
   * @see SearchRequest#SearchRequest(java.util.Map<java.lang.String,java.lang.Object>)
   */
  public SearchRequest(final Map<String, Object> searchParams, final Sort sort) throws SearchException {
      this(searchParams, null, sort);
  }


  /**
   * <p>根据查询参数拼Search<br/>
   * 查询参数格式：property_op=value 或 customerProperty=value<br/>
   * customerProperty查找规则是：1、先查找domain的属性，2、如果找不到查找domain上的SearchPropertyMappings映射规则
   * 属性、操作符之间用_分割，op可省略/或custom，省略后值默认为custom，即程序中自定义<br/>
   * 如果op=custom，property也可以自定义（即可以与domain的不一样）,
   * </p>
   *
   * @param searchParams 查询参数组
   * @param page         分页
   * @param sort         排序
   */
  public SearchRequest(final Map<String, Object> searchParams, final Pageable page, final Sort sort)
          throws SearchException {

      toSearchFilters(searchParams);

      merge(sort, page);
  }


  private void toSearchFilters(final Map<String, Object> searchParams) throws SearchException {
      if (searchParams == null || searchParams.size() == 0) {
          return;
      }
      for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
          String key = entry.getKey();
          Object value = entry.getValue();

          addSearchFilter(SearchFilterHelper.newCondition(key, value));
      }
  }
  
  private void merge(Sort sort, Pageable page) {
    if (sort == null) {
        sort = this.sort;
    }
    if (page == null) {
        page = this.page;
    }

    //合并排序
    if (sort == null) {
        this.sort = page != null ? page.getSort() : null;
    } else {
        this.sort = (page != null ? sort.and(page.getSort()) : sort);
    }
    //把排序合并到page中
    if (page != null) {
        this.page = new PageRequest(page.getPageNumber(), page.getPageSize(), this.sort);
    } else {
        this.page = null;
    }
  }
  
  @Override
  public Searchable addSearchFilter(SearchFilter searchFilter) {
      if (searchFilter == null) {
          return this;
      }
      if (searchFilter instanceof Condition) {
          Condition condition = (Condition) searchFilter;
          String key = condition.getKey();
          searchFilterMap.put(key, condition);
      }
      int index = searchFilters.indexOf(searchFilter);
      if(index != -1) {
          searchFilters.set(index, searchFilter);
      } else {
          searchFilters.add(searchFilter);
      }
      return this;

  }

  @Override
  public Searchable addSearchFilter(String searchProperty, SearchOperator operator, Object value)
      throws SearchException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable addSearchParam(String key, Object value) throws SearchException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable addSearchParams(Map<String, Object> searchParams) throws SearchException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable addSearchFilters(Collection<? extends SearchFilter> searchFilters) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable or(SearchFilter first, SearchFilter... others) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable and(SearchFilter first, SearchFilter... others) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable removeSearchFilter(String key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable removeSearchFilter(String searchProperty, SearchOperator operator) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> Searchable convert(Class<T> entityClass) throws InvalidSearchValueException,
      InvalidSearchPropertyException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable markConverted() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable setPage(Pageable page) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable setPage(int pageNumber, int pageSize) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable addSort(Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Searchable addSort(Direction direction, String property) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<SearchFilter> getSearchFilters() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isConverted() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean hasSearchFilter() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean hashSort() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void removeSort() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean hasPageable() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void removePageable() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Pageable getPage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Sort getSort() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean containsSearchKey(String key) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public <T> T getValue(String key) {
    // TODO Auto-generated method stub
    return null;
  }

}

