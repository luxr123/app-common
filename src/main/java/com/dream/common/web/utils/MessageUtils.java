
package com.dream.common.web.utils;

import org.springframework.context.MessageSource;

/**
 * User: xiaorui.lu
 * Date: 2013年12月15日 下午9:17:29
 */
public class MessageUtils {

  private static MessageSource messageSource;

  /**
   * 根据消息键和参数 获取消息
   * 委托给spring messageSource
   *
   * @param code 消息键
   * @param args 参数
   * @return
   */
  public static String message(String code, Object... args) {
      if (messageSource == null) {
          messageSource = SpringUtils.getBean(MessageSource.class);
      }
      return messageSource.getMessage(code, args, null);
  }

}

