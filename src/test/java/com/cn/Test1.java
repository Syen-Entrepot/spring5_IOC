package com.cn;

import com.cn.pojo.People;
import com.cn.pojo.Pig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 14:20
 */
public class Test1 {
    @Test
    public void m1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        People people=ctx.getBean("people",People.class);
        /*System.out.println(people.getFriends());*/
        System.out.println(Arrays.toString(people.getFriends()));
        System.out.println(people.getFriends().length);
        System.out.println(people.getNums());

        System.out.println(people.getCats());
        System.out.println(people.getPigs());
        System.out.println(people.getUsers());
    }
    @Test
    public void m2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
       Pig pig= ctx.getBean("pig",Pig.class);
       Pig pig1= ctx.getBean("pig1",Pig.class);
       System.out.println(pig);
       System.out.println(pig1);

    }
}
