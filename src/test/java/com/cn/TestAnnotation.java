package com.cn;

import com.cn.Service.Hello.hello;
import com.cn.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 22:12
 */
public class TestAnnotation {

@Test
    public void m1(){
    ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    UserService userService= ctx.getBean("userService",UserService.class);
    userService.eat();
}
    @Test
    public void m2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        hello u= ctx.getBean("helloWorld",hello.class);
        u.hei();

    }

}
