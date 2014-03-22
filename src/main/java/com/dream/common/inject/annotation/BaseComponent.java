package com.dream.common.inject.annotation;

import java.lang.annotation.*;


/**
 * 查找注解的字段作为BaseService/BaseRepository数据
 * 即
 * 1、查找对象中的注解了@BaseComponent的对象
 * 2、
 * 调用BaseCRUDController.setBaseService 设置BaseService
 * 调用BaseService.setBaseRepository 设置BaseRepository
 * User: xiaorui.lu
 * Date: 2013年12月17日 下午3:11:27
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseComponent {

}

