package com.wangzhaoyu.core.interceptor;

import com.wangzhaoyu.core.util.ContextEnvironment;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangzhaoyu on 2016/10/14.
 * web请求上下文拦截器
 */
public class ContextInterceptor extends HandlerInterceptorAdapter {
    public ContextInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ContextEnvironment.setRequestThreadLocal(request);
        ContextEnvironment.setResponseThreadLocal(response);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ContextEnvironment.removeRequest();
        ContextEnvironment.removeResponse();
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
