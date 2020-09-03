package org.example.config;

import org.example.interceptor.UrlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author x
 * @description mvc 配置
 * @Date: 2020/9/3 19:13
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    InterceptorRegistration interceptorRegistration = registry.addInterceptor(new UrlInterceptor());
    interceptorRegistration.addPathPatterns("/**");
    interceptorRegistration.excludePathPatterns(
        "/",
        "/login",
        "/**/*.html",
        "/**/*.js",
        "/**/*.css");
  }
}
