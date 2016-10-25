package com.wangzhaoyu.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangzhaoyu on 2016/10/14.
 * web上下文环境
 */

public class ContextEnvironment {

    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();

    private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();

    public static void setRequestThreadLocal(HttpServletRequest request){
        requestThreadLocal.set(request);
    }

    public static void setResponseThreadLocal(HttpServletResponse response){
        responseThreadLocal.set(response);
    }

    public static HttpServletRequest getRequest(){
        return requestThreadLocal.get();
    }
    public static HttpServletResponse getResponse(){
        return responseThreadLocal.get();
    }

    public static void removeRequest(){
        requestThreadLocal.remove();
    }

    public static void removeResponse(){
        responseThreadLocal.remove();
    }
}
