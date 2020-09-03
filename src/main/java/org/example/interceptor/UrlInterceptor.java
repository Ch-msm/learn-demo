package org.example.interceptor;

import org.example.constant.Constant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author x
 * @description 配置拦截器
 * @Date: 2020/9/3 19:13
 */
public class UrlInterceptor implements HandlerInterceptor {

  /**
   * 进入Controller层之前拦截请求，默认是拦截所有请求
   *
   * @param httpServletRequest  request
   * @param httpServletResponse response
   * @param o                   object
   * @return 是否拦截当前请求，true表示拦截当前请求，false表示不拦截当前请求
   * @throws Exception 可能出现的异常
   */
  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    String token = httpServletRequest.getHeader("token");
    String requestURI = httpServletRequest.getRequestURI();
    System.out.println(requestURI);
    return Constant.TOKEN.containsKey(token);
  }
}
