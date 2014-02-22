
package com.dream.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import com.dream.common.entity.AbstractEntity;
import com.dream.common.inject.support.InjectBaseDependencyHelper;
import com.dream.common.repository.BaseRepository;

/**
 * <p>抽象service层基类 提供一些简便方法
 * <p/>
 * <p>泛型 ： M 表示实体类型；ID表示主键类型
 * <p/>
 * User: xiaorui.lu
 * Date: 2013年12月17日 下午2:02:29
 */
public abstract class BaseService<M extends AbstractEntity, ID extends Serializable> implements InitializingBean {


  protected BaseRepository<M, ID> baseRepository;


  public void setBaseRepository(BaseRepository<M, ID> baseRepository) {
      this.baseRepository = baseRepository;
  }
  
  @Override
  public void afterPropertiesSet() throws Exception {

      InjectBaseDependencyHelper.findAndInjectBaseRepositoryDependency(this);

      Assert.notNull(baseRepository, "BaseRepository required, Class is:" + getClass());
  }

  /**
   * 保存单个实体
   *
   * @param m 实体
   * @return 返回保存的实体
   */
  public M save(M m) {
      return baseRepository.save(m);
  }

  public M saveAndFlush(M m) {
      m = save(m);
      baseRepository.flush();
      return m;
  }

  /**
   * 更新单个实体
   *
   * @param m 实体
   * @return 返回更新的实体
   */
  public M update(M m) {
      return baseRepository.save(m);
  }

  /**
   * 根据主键删除相应实体
   *
   * @param id 主键
   */
  public void delete(ID id) {
      baseRepository.delete(id);
  }

  /**
   * 删除实体
   *
   * @param m 实体
   */
  public void delete(M m) {
      baseRepository.delete(m);
  }

  /**
   * 根据主键删除相应实体
   *
   * @param ids 实体
   */
  public void delete(ID[] ids) {
      baseRepository.delete(ids);
  }


  /**
   * 按照主键查询
   *
   * @param id 主键
   * @return 返回id对应的实体
   */
  public M findOne(ID id) {
      return baseRepository.findOne(id);
  }

  /**
   * 实体是否存在
   *
   * @param id 主键
   * @return 存在 返回true，否则false
   */
  public boolean exists(ID id) {
      return baseRepository.exists(id);
  }

  /**
   * 统计实体总数
   *
   * @return 实体总数
   */
  public long count() {
      return baseRepository.count();
  }

  /**
   * 查询所有实体
   *
   * @return
   */
  public List<M> findAll() {
      return baseRepository.findAll();
  }

  /**
   * 按照顺序查询所有实体
   *
   * @param sort
   * @return
   */
  public List<M> findAll(Sort sort) {
      return baseRepository.findAll(sort);
  }

  /**
   * 分页及排序查询实体
   *
   * @param pageable 分页及排序数据
   * @return
   */
  public Page<M> findAll(Pageable pageable) {
      return baseRepository.findAll(pageable);
  }

  /**
   * 按条件分页并排序查询实体
   *
   * @param searchable 条件
   * @return
   */

  /**
   * 按条件不分页不排序查询实体
   *
   * @param searchable 条件
   * @return
   */

  /**
   * 按条件排序查询实体(不分页)
   *
   * @param searchable 条件
   * @return
   */


  /**
   * 按条件分页并排序统计实体数量
   *
   * @param searchable 条件
   * @return
   */

}

