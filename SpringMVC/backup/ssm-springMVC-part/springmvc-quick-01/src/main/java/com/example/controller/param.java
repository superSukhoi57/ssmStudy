package com.example.controller;



import com.example.pojo.PersonJson;
import com.example.pojo.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Controller
@RequestMapping("param")//提取相同的地址
public class param {
      //直接接收：param/data?name=Tony&age=17
    //这种方法要求形参名要和参数名一致！！没传递也不报错！
    @RequestMapping("/data")
    @ResponseBody//FIXME：这个注解就是叫springMVC不要去找图形解析器！！返回的是字符串想在浏览器直接显示就要加
    public String directly(String name,int age){
        System.out.println("name is"+name+"age is"+age);
        return "successful";
    }

 /*
 注解指定：指定那个是必须传的，那个是不必要的但设置默认值
 例如：/param/data_set?account=root&page=2中account必须，age没传默认为1.
 RequestParam的value设置地址参数对应的形参变量（形参名和请求参数一致可以不写！），required设置参数是否必要，defaultValue就是设置默认值
  */

    @GetMapping("data_set")
    @ResponseBody
    public String dataSet(@RequestParam(value="account")String username,
                          @RequestParam(required = false,defaultValue = "1")int page){

        System.out.println("username is "+username+" page is"+page);

        return "successful at data_set  "+"username is "+username+" page is"+page;

    }

    /*
    传入多个值，用集合接收值。
    param/data_list?hbs=穿越火线&hbs=羽毛球
    public String data_list(String[] hbs )可以实现传递多个值！

    用List：public String data_list(@RequestParam List<String> hbs )!
    用List一定要加@Requestparam注解！因为将一个 List<String> 类型的参数 hbs 自动装配到 data_list 方法中，这是不可能的，
因为 List 是一个接口，它没有构造函数。加了直接HanderAdapter就会将这个注解用add的方法加入到这个list

     */
    @RequestMapping("data_list")
    @ResponseBody
    public String data_list(@RequestParam List<String> hbs ){
        System.out.println("hbs"+hbs);
        return "List";
    }


    /*
    传递的参数给实体对象赋值
    /param/data_object?name=tony&age=17
     */
    @RequestMapping("data_object")
    @ResponseBody
    public String data_object(User user){
        System.out.println(user);
        return user.toString();
    }


    /*
    路径传参！像：root/param1/param2/123456   这后面三个就是参数。
    要求：设置动态路径，接收动态路径参数。
    /param/账号/密码

    注意如果直接 public String rodeParam(String account,String password)这种方式直接收param形式的参数。
    所以要用@ParthVaruable来指定动态路径参数。如果形参和接收的参数名不一样可以用key来指定形参接收哪个。
     */
    @RequestMapping("way/{account}/{password}")
    @ResponseBody
    public String rodeParam(@PathVariable String account,@PathVariable String password){
        System.out.println("account is:"+account+"  \npassword is"+password);
        return "动态路径参数验证成功！";
    }


    /*
    Json传递数据！用Post方式！
    /param/json   请求体：{name,age,gender}
    前端报415--》不支持媒体类型，原因是java只支持路径参数和param的！！不支持json
    解决方法：1.导入json处理的依赖；2.给handlerAdapter配置json转换器！3.发送的是json请求头的Content-Type就业设置为json，xml就xml！

     */
    @PostMapping("json")
    @ResponseBody
    public String data_json(@RequestBody PersonJson person){
        System.out.println(person.toString());
        return person.toString();
    }

 //————————————————————————cookie开始——————————————————————————————————————————


    /*]
    这段函数是在用户的HTTP响应中设置了一个名为"cookieName"的cookie，并且其值为"cookieIkun"
    这意味着当客户端（通常是浏览器）接收到这个HTTP响应后，它将存储这个cookie。在后续的请求中，客户端将会自动将这
个cookie发送回服务器，除非这个cookie已经过期或被客户端删除。
     */
    @GetMapping("saveCookie")
    @ResponseBody
    //TODO：使用到：HttpServletResponse原生对象，还有其他的原生对象
    public  String saveCookie(HttpServletResponse response ){
        Cookie cookie = new Cookie("cookieName","cookieIkun");
        response.addCookie(cookie);
        return "OK";

    }

    /*
   接收cookie数据！
    使用@CookieValue注解！！
    */
    @RequestMapping("cookie")
    @ResponseBody
    public  String cookier(@CookieValue(value = "cookieName") String value){
        System.out.println("cooike is "+value);
        return value;
    }


    /*
    在上面这段代码里浏览器先访问localhost:8080/param/saveCookie后端就调用saveCookie会生成一个cookie并发送会客户端储存！
    然后访问localhost:8080/param/cookie后端就可以得到之前发送给客户端的cookie！
     */
    //————————————————————————————————end of cooke——————————————————————————————————

    /*
    接收请求头
public String header(@RequestHeader("具体的想要的请求头")String host )
     */

    @RequestMapping("header")
    @ResponseBody
    public String header(@RequestHeader("host")String host ){
        System.out.println("host is "+host);
        return host;
    }
}
