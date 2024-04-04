package com.example.controller;

import com.example.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController=@Controller+@ResponBody
@Controller
public class HelloController {



/*
    TODO：外部地址访问设置和视图解析器的使用
    对外的地址访问，将地址注册到HandlerMapping！不要求/开头，有多个{"地址1  ","地址2"……}

    支持模糊*任意一层字符串|**任意层任意字符串
    /user/ *->user/a user/aaaag可以/user/a/b 不行
    /user/ * *->user user/a user/a/a/a/a/a/a

    在类上添加@RequestMapping的区别；
        添加在类上的requestmappig会在这个类的方法的requestmapping的地址前自动添加类的地址，相当于将方法的共有的地址提取到类那里
        访问地址：类+方法！

    默认情况下@RequestMapping任何方式都可以访问！
        指定一种方式访问: @RequestMapping(value = "springmvc/hello",method = RequestMethod.GET)
        多种方式访问： @RequestMapping(value = "springmvc/hello",method = {RequestMethod.GET，RequestMethod.POST})
        不符合机会报405异常
        进阶直接可以用@GetMapping()就是 @RequestMapping(value = "springmvc/hello",method = RequestMethod.GET)

 */

    //不使用视图解析器
    @RequestMapping(value = "springmvc/hello")
    @ResponseBody//告诉mvc直接返回字符串，不要去找视图解析器！
    public String hello(){
        System.out.println("hello world!");
        //返回给前端！s
        return "hello world!";
    }

    //使用视图解析器
    @RequestMapping("index")
    //不加@ResponseBody就会去找视图解析器，渲染页面！
    public String index(HttpServletRequest request){
        //FIXME:共享域例子。
        request.setAttribute("data","成功在共享域设置data的值并被jsp文件通过#${value}使用！");
        return "index";
    }



    //转发
    /*
    1.方法返回值写成字符串；2.不使用视图解析器；    3.返回的字符串前加forward:/ + 目标url！！有这个registory才不会拼接前后缀！
        那个目标url是@RequestMapping("index")handlerMapping我们注册的地址！！！
     */
    @RequestMapping("forward")
    public String forward(){
        System.out.println("转发成功！");
        return "forward:/index";
    }

    //重定向；过程和转发差不多。
    @RequestMapping("redirect")
    public String redirect(){
        System.out.println("重定向成功！");
        return "redirect:/index";
    }

    //TODO：后台返回json
    /*
    1.要在配置文件添加EnableWebMvc注解开启json处理器
    2.加@ResponBoy不使用视图解析器，直接返回
     */
    @RequestMapping("returnJson")
    @ResponseBody
    public User returnJson(){
        User user=new User();
        user.setAge(15);
        user.setName("jenny");
        return user;//  会在handlerAdapter里面转化为json！
    }
    //也可以public List<User> returnJson()操作一样！



}
