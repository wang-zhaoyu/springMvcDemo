package com.wangzhaoyu.core.controller;

import com.wangzhaoyu.core.util.ContextEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by wangzhaoyu on 2016/10/14.
 */
public class BaseController {
    //获取logger
    Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * text/json
     */
    protected final String MIME_JSON = "text/json";

    /**
     * text/xml
     */
    protected final String MIME_XML = "text/xml";

    /**
     * text/plain
     */
    protected final String MIME_PLAIN = "text/plain";

    /**
     * text/html
     */
    protected final String MIME_HTML = "text/html";

    /**
     * 系统采用的统一的编码
     */
    public static String CHARSET = "UTF-8";
    /**
     * 获取request对象
     * @return
     */
    public HttpServletRequest getRequest(){
        return ContextEnvironment.getRequest();
    }

    /**
     * 获取response对象
     * @return
     */
    public HttpServletResponse getResponse(){
        return ContextEnvironment.getResponse();
    }

    PrintWriter getOut(HttpServletResponse response,String mime){
        String contentType = mime + ";charset=" + CHARSET;
        PrintWriter out = null;
        try {
            if(response == null){
                logger.error("获取输出路失败");
                throw new Exception("获取输出流失败");
            }
            response.setContentType(contentType);
            out = response.getWriter();
        } catch (Exception e) {
            logger.error("获取输出流失败");
            throw new RuntimeException("获取输出流失败");
        }
        return out;
    }

    /**
     * 获取输出流，默认问json类型
     * @return
     */
    PrintWriter getOut(){
        return getOut(MIME_JSON);
    }
    PrintWriter getOut(String mime){
        return getOut(getResponse(),mime);
    }
}
