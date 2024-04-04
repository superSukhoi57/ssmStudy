package com.example.service.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/*

1、定义方法储存增强代码
使用注解配置 指定插入目标方法的位置。
前置：@Before
后置：AfterReturning
异常：AfterThrowing
环绕：@Around

try{
    前置
    目标方法
    后置
}catch(){
    异常
}finally{
    最后
}

2、配置切点表达式"execution(* com.example.service.imp.*.*(..))"来选中目标方法！！
3、补全注解：加入ioc@component；  配置切面@Aspect
4、开启注解的支持！！！aspectj，配置类（@EnableAspectJAutoProxy）；xml（<aop:aspectj-autoproxy/>）！！！

5、JoinPoint joinPoint包含目标方法的详细信息！
    返回的结果-@AfterReturning
用(0bject result)result接收返回结果:public void common(JoinPoint joinPoint,Object result){
要在@AfterReturning(value = "execution(* com..impl.*.*(..))",returning =“形参名”即可")指定形参名！

    异常的AfterThrowing的操作方法和上面一样！
    @AfterThrowing(value = "execution(* com.example.service.imp.*.*(..))",throwing = "e")
     public void error(JoinPoint joinPoint,Throwable e){
 */


/*
 TODO:获取通知细节信息
1. JointPoint 接囗
需要获取方法签名、传入的实参等信息时，可以在通知方法声明 JoinPoint 类型的形参,
要点 1:JoinPoint 接口通过 getSignature() 方法获取目标方法的签名(方法声明时的完整信息)
要点 2:通过目标方法签名对象获取方法名
要点 3:通过 JoinPoint 对象获取外界调用目标方法时传入的实参列表组成的数组

 */

/*
TODO:切点表达式的提取和复用
1.当前类中提取定义一个空方法
注解 @Pointcut()
增强注解中引用切点表达式的方法即可,最好用public void声明；
2、可以创建一个存储切点表达式的类，单独维护切点表达式！
在其他类引用：类的全限定符.方法名();
 */
@Component
@Aspect
public class Log {

    //提取切点表达式！！
    @Pointcut("execution(* com.example.service.imp.*.*(..))")
    public void pc(){}

    @Before("pc()")
    public void start(JoinPoint joinPoint){
        //1.获取方法属于的类的信息
        String simpleName =joinPoint.getTarget().getClass().getSimpleName();
        //2.获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();
        String s= Modifier.toString(modifiers);
        String name=joinPoint.getSignature().getName();//获取方法名
        // 3.获取参数列表
        Object[]args=joinPoint.getArgs();//获取目标方法参数


        System.out.println("开始运算！");
    }
    @After("com.example.service.advice.pointCutRepository.repoPc()")//使用一个存储切点表达式的类的方法！！！
    public void end(JoinPoint joinPoint){
        System.out.println("运算结束！");
    }
    @AfterReturning(value = "execution(* com.example.service.imp.*.*(..))",returning = "result")
    public void common(JoinPoint joinPoint,Object result){
        System.out.println("正常返回！");
    }
    @AfterThrowing(value = "execution(* com.example.service.imp.*.*(..))",throwing = "e")
    public void error(JoinPoint joinPoint,Throwable e){
        System.out.println("运算出错！");
    }



    //———————————————————————————————环绕通知——————————————————————————
    //一定要用try的catch的throw new 来抛出异常信息，才能被外界捕获！！！其他的在方法那里声明不行！
    @Around("pc()")
    public Object transaction(ProceedingJoinPoint joinPoint){
//保证目标方法被执行即可
        Object[]args = joinPoint.getArgs();
        Object result = null;

        try {
            //增强代码->before
            System.out.println("开启事务");
            result= joinPoint.proceed(args);//这句话就是执行事务的核心代码

            System.out.println("结束事务");
        }catch(Throwable e){
            //@AfterThrowing
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }finally {

        }
        return result;
    }
}

