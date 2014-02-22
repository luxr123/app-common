package com.dream.common.repository.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.query.QueryLookupStrategy;

import com.dream.common.repository.BaseRepository;
/**
 * 基础Repostory简单实现 factory bean 
 * User: xiaorui.lu 
 * Date: 2013年12月13日 下午5:53:32
 */
public class SimpleBaseRepositoryFactoryBean<R extends JpaRepository<M, ID>, M, ID extends Serializable>
    extends JpaRepositoryFactoryBean<R, M, ID> {

  public SimpleBaseRepositoryFactoryBean() {}

  @Override
  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
    return new SimpleBaseRepositoryFactory(entityManager);
  }
}

class SimpleBaseRepositoryFactory<M, ID extends Serializable> extends JpaRepositoryFactory {

  private EntityManager entityManager;

  public SimpleBaseRepositoryFactory(EntityManager entityManager) {
    super(entityManager);
    this.entityManager = entityManager;
  }

  @Override
  protected Object getTargetRepository(RepositoryMetadata metadata) {
    Class<?> repositoryInterface = metadata.getRepositoryInterface();
    if (isBaseRepository(repositoryInterface)) {
      JpaEntityInformation<M, ID> entityInformation = getEntityInformation((Class<M>) metadata.getDomainType());
      SimpleCustomRepository repository = new SimpleCustomRepository<M, ID>(entityInformation, entityManager);
      return repository;
    }
    return super.getTargetRepository(metadata);
  }

  protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
    if (isBaseRepository(metadata.getRepositoryInterface())) {
      return SimpleCustomRepository.class;
    }
    return super.getRepositoryBaseClass(metadata);
  }

  private boolean isBaseRepository(Class<?> repositoryInterface) {
    return BaseRepository.class.isAssignableFrom(repositoryInterface);
  }
  
  @Override
  protected QueryLookupStrategy getQueryLookupStrategy(QueryLookupStrategy.Key key) {
      return super.getQueryLookupStrategy(key);
  }

}
