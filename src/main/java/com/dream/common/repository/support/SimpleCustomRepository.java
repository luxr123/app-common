
package com.dream.common.repository.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import com.dream.common.repository.BaseRepository;
import com.dream.common.search.Searchable;


/**
 * 抽象基础Custom Repository 实现
 * User: xiaorui.lu
 * Date: 2013年12月17日 下午4:44:27
 */
public class SimpleCustomRepository<M, ID extends Serializable> extends SimpleJpaRepository<M, ID> implements BaseRepository<M, ID> {

  private final EntityManager entityManager;
  
  public SimpleCustomRepository(Class<M> domainClass, EntityManager em) {
    super(domainClass, em);

    entityManager=em;
  }

  public SimpleCustomRepository(final JpaEntityInformation<M, ?> entityInformation, final EntityManager entityManager) {  
    super(entityInformation, entityManager);  
    this.entityManager = entityManager;  
}
  @Override
  public void delete(ID[] ids) {
    // TODO Auto-generated method stub
    
  }

  /////////////////////////////////////////////////
  ///////////////////自定义实现////////////////////
  /////////////////////////////////////////////////
  @Override
  public Page<M> findAll(Searchable searchable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long count(Searchable searchable) {
    // TODO Auto-generated method stub
    return 0;
  }

  
}

