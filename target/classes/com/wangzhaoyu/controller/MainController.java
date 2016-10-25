package com.wangzhaoyu.controller;

import com.wangzhaoyu.core.controller.BaseController;
import com.wangzhaoyu.dubbo.service.DubboRedisService;
import com.wangzhaoyu.pojo.User;
import com.wangzhaoyu.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *@Author:wanghzoayu
 *@Description: 首页逻辑控制层
 *@Date:Create in 2016/10/14 17:14
 */
@Controller
public class MainController extends BaseController{
    Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private TestService testSetvice;

    @Autowired
    private DubboRedisService dubboRedisService;

   /**
    *@Author:wanghzoayu
    *@Description: 跳转到登录页面
    *@Date:Create in 2016/10/14 17:13
    *@Modified By:
    */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(){
        return "login";
    }

   /**
    *@Author:wanghzoayu
    *@Description: 跳转到首页
    *@Date:Create in 2016/10/14 17:13
    *@Modified By:
    */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index2(){

        dubboRedisService.setObj("test","hello word");
        String str =  dubboRedisService.getObj("test");
        System.out.printf("查询结果=================："+str);
        return "index";
    }
    /**
     *@Author:wanghzoayu
     *@Description: 查看用户信息
     *@Date:Create in 2016/10/14 17:14
     *@Modified By:
     */
    @RequestMapping("/user")
    public String  User(){
        List<User> users = testSetvice.queryAll();
        for(User u : users ){
            System.out.printf("用户的信息是:"+u.toString());
        }
        return "user";
    }
}
