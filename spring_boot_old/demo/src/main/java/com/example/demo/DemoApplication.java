package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//添加的导入文件
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//添加的注解
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//添加的代码
@RequestMapping("/helloword")//处理helloword的get请求！端口号后面的就是请求！
public String helloword(){
		return  "hello,word!";
}


}
