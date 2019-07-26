package com.cn;

import com.cn.Service.ProviderService;
import com.cn.dao.ProviderDao;
import com.cn.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 15:02
 */
public class Test_autowire {

    @Test
    public void m1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("autowired.xml");
        User u=ctx.getBean("user",User.class);
        System.out.println(u.getPig().getName());

    }
    @Test
    public void m2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("autowired.xml");
        ProviderService providerService=ctx.getBean("providerService",ProviderService.class);
        providerService.update();

    }

    @Test
    public void m_resources(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("resources.xml");
       ProviderDao providerDao=ctx.getBean("providerDao1",ProviderDao.class);
       System.out.println(providerDao.getDriver());
       System.out.println(providerDao.getUser());
       System.out.println(providerDao.getUrl());
       System.out.println(providerDao.getPassword());


    }

}
