package com.example.Filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/*
FIXME：配置拦截器
在配置类实现 WebMvcConfigurer接口的前提下重写
 public void addInterceptors
 */
public class interceptor implements HandlerInterceptor {

    /*
    参数说明：
    request：请求对象
    response：响应对象
    handler：就是我们要调用的方法对象
    return：true放行；false拦截
    throws：exception

    modleAndView：返回的视图和共享域数据对象

     */

    //执行handler之前调用的拦截方法！如编码格式、登录保护、权限处理……
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return HandlerInterceptor.super.preHandle(request, response, handler);
        System.out.println("在handler前拦截成功并放行！");
        return true;
    }

    //handler执行完毕后执行的方法，，没拦截机制了！
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //整体处理完毕执行时
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
