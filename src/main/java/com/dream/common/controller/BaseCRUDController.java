package com.dream.common.controller;

import java.io.Serializable;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.dream.common.entity.AbstractEntity;
import com.dream.common.inject.support.InjectBaseDependencyHelper;
import com.dream.common.service.BaseService;

/**
 * 基础CRUD 控制器 User: xiaorui.lu Date: 2013年12月17日 下午8:22:01
 */
public abstract class BaseCRUDController<M extends AbstractEntity, ID extends Serializable> extends
    BaseController<M, ID> implements InitializingBean {

  protected BaseService<M, ID> baseService;

  private boolean listAlsoSetCommonData = false;

  /**
   * 设置基础service
   * 
   * @param baseService
   */
  public void setBaseService(BaseService<M, ID> baseService) {
    this.baseService = baseService;
  }
  
  @Override
  public void afterPropertiesSet() {
      InjectBaseDependencyHelper.findAndInjectBaseServiceDependency(this);
      Assert.notNull(baseService, "BaseService required, Class is:" + getClass());
  }

  /**
   * 列表也设置common data
   */
  public void setListAlsoSetCommonData(boolean listAlsoSetCommonData) {
    this.listAlsoSetCommonData = listAlsoSetCommonData;
  }

  /**
   * 权限前缀：如sys:user 则生成的新增权限为 sys:user:create
   */

  /**
   * 仅返回表格数据
   * 
   * @param searchable
   * @param model
   * @return
   */
}