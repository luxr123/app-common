
package com.dream.common.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
 * 抽象实体基类
 * User: xiaorui.lu
 * Date: 2013年12月13日 下午8:00:18
 */
public abstract class AbstractEntity<ID extends Serializable>{

  public abstract ID getId();

  /**
   * Sets the id of the entity.
   *
   * @param id the id to set
   */
  public abstract void setId(final ID id);


  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {

      if (null == obj) {
          return false;
      }

      if (this == obj) {
          return true;
      }

      if (!getClass().equals(obj.getClass())) {
          return false;
      }

      AbstractEntity<?> that = (AbstractEntity<?>) obj;

      return null == this.getId() ? false : this.getId().equals(that.getId());
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {

      int hashCode = 17;

      hashCode += null == getId() ? 0 : getId().hashCode() * 31;

      return hashCode;
  }

  @Override
  public String toString() {
      return ReflectionToStringBuilder.toString(this);
  }
}

