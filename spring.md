# spring

## 简介

​          是一个框架，2002年左右，rod，讨论java企业级开发的问题,EJB,有点繁琐，继承某个类，实现好几个接口

写一堆方法。

​          简化我们的开发工作，构建了最早版本的spring

``` java
1 Girl g=new Girl();
2 //写死l
3 new PrettyGirl();
4 new YoungGirl();
```

``` java
1 Pay pay;
2 pay =new wxPay();
3 pay =new AliPay();
4 pay = 手工支付
```

​      大部分的对象应该从容器当中获取，而不是进行java硬编码。

容器：就由它来写，以后我们要什么，就从这个容器里面拿，在容器去声明告诉它，给我准备什么。

### 基础技术

- java

- 反射

- xml

- xml解析

- 代理

- 大量涉及模式

  

### spring基础环境搭建

1.添加spring的依赖

> ```xml
> <dependency>
>       <groupId>org.springframework</groupId>
>       <artifactId>spring-context</artifactId>
>       <version>5.1.8.RELEASE</version>
>     </dependency>
> ```

2.编写一个spring的配置文件

> ```java
> <?xml version="1.0" encoding="UTF-8"?><beans xmlns="http://www.springframework.org/schema/beans"       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"><!--将对象的创建交给spring容器，在这个配置文件里面去声明我要什么对象class:写java类的全限定类名,它是通过全类名然后使用反射的技术进行创建的id:id是给这个对象在整个应用程序上下文当中去个名字以方便区分，-->    <bean id="girl" class="com.cn.pojo.Girl">    </bean></beans>
> ```

3.通过spring的应用程序上下文对象获取对象

第一步：javabean

``` java
package com.cn.pojo;

/**
 * @author Syen
 * @date 2019/7/23 0023-上午 3:15
 */
public class Girl {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

```

``` java
//test
package com.cn;

import com.cn.pojo.Girl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Syen
 * @date 2019/7/23 0023-上午 3:22
 */
public class TestSpring {
    @Test
    public void m1(){
        //1.获取上下文对象，spring里面声明对象需要通过上下文对象获取

        ApplicationContext cts=new ClassPathXmlApplicationContext("applicationContext.xml");
         //2.通过这个对象获取我们的girl
        Girl g=(Girl) cts.getBean("girl");
        System.out.println(g);

    }
}

```

### 普通编写VSspring方式

​        普通的获取对象的方式，所有的对象之间的依赖，类之间的依赖关系都是在java代码里面维护的，很难维护的，如果说我们有替换方案，替换比较困难。

​       对象的产生全部是在配置文件里面完成的，其实我们想分析关系，直接在配置文件里面就看出来了，更方便

spring核心内容

- IOC
- AOP

IOC概念：

​          控制反转：1.什么控制。2.谁反转谁

控制：创建对象，彼此关系的权利

控制权是在开发人员在程序代码当中进行掌控。new

夺取控制权

反转给spring的容器

- 声明要什么

- spring容器来进行具体的控制

  

改变了编程方式

依赖注入（DI）

依赖：接口，环境等等

> ```java
> //注入
> <bean class="com.cn.pojo.AliPay" id="pay1"></bean><bean class="com.cn.pojo.WxPay" id="pay"></bean>
> ```



### 值的注入

- setter注入（最常用）

  + 必须其字段有对应setter方法才可以完成name setName()

  + 通过property子节点完成注入

    > ```xml
    > <!--值的注入--><bean class="com.cn.pojo.Girl" id="mygirl">    <!--name指定要注入的属性名称，value给其赋值-->  <property name="name" value="林允儿"/></bean>
    > ```

  >```java
  >@Test
  >public void scalxml(){   
  >    /*读取多个配置文件*/    
  >    ApplicationContext cts=new ClassPathXmlApplicationContext            
  >      (new String[{"beans.xml","beans1.xml"});       /*下面的方式由于指定了class不需要强转*/    Girl g=cts.getBean("mygirl",Girl.class);    Girl g1=cts.getBean("yourgirl",Girl.class);    System.out.println(g.getName());
  >                  }
  >```

  

  

​          注意：

默认是通过无参构造器完成对象的创建的

### bean元素

属性探讨

- abstract: 该bean将无法被实例化（因为抽象类是用来继承的）

- parent：指定它的父bean是谁，将会继承父bean的所有内容，通过id来进行指引

  ![1564114040092](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564114040092.png)

- destro-method:指定这个bean最后销毁的时候一定执行的方法，适合于清理型工作，触发条件是必须bean确实是被销毁才发生,如：

  + 容器close会触发

    ![1564114895294](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564114895294.png)

  + refresh(刷新):也会触发

    ![1564114959115](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564114959115.png)

  + 过时的destroy方法也可以触发（不推荐使用）

    ![1564115166539](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564115166539.png)

    

    

    

- init-method:指定bean的初始化方法，准备性的工作。

- name:别名可以通过它一样获取，可以写多个。

  

  ![1564115934585](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564115934585.png)

​                     ![1564115985261](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564115985261.png)

- scope

  + singl：单例模式（spring默认值），**spring上下文**当中，只有一个实例
  + prototype：原型模式，要一个就给一个

- lazy-init（延迟初始化）：true就是spring一上来直接初始化我们的bean,当我们需要使用它的时候，spring才会初始化。

  + 直接初始化
    + 它应用程序启动会慢一点，内存消耗大一点
    + 当我们使用bean的时候会快一些
  + 延迟初始化
    + 程序启动快，内存消耗小
    + 使用bean的时候慢一些

- depend-on: 依赖的bean，如果某一个bean的使用严重依赖另外一个bean的准备的话，就可以配置depend-on

  非字面值可以描述的值的注入问题

  ![1564119148838](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564119148838.png)

​                  通过ref指向另外一个bean的id

​                 关于在spring的配置文件中单独定义别名

- alias：标签完成

spring 多个配置文件里面的bean是可以互相引用的（被上线文扫描到的前提下）

- 构造柱人

  + 构造注入方式一

             ``` java
  <!--构造方式一通过名字来进行注入-->  
      <bean class="com.cn.pojo.Car" id="car">      
      <constructor-arg name="name" value="宝马"/>      
      <constructor-arg name="price" value="500"/>     
      <constructor-arg name="speed" value="200"/>  
      </bean>
             ```

  

  + 构造注入方式二(最好不要有，所以不写)

    > ```java
    > 
    > ```

​                       

## spring当中各种值的注入

- 数组
- List
- Set
- Map

如果其对应的值是简单的字面值，就是直接就可以了，如果是一个其他类，那么就使用内部bean

## 自动注入

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--<bean class="com.cn.pojo.User" id="user" autowire="byType">
        <property name="name" value="陈慧琳"/>
        <property name="address" value="香港"/>

    </bean>-->

   <bean class="com.cn.pojo.User" autowire="constructor" id="user">
         <constructor-arg name="name" value="韩红"/>
    </bean>

    <!--primary默认值为true
    如果有多个bean，并且它将会按类型注入给其它bean,那么只能有一个primary为true

    -->

    <!--<bean class="com.cn.pojo.User" id="user" autowire="default">

    </bean>
-->
    <bean class="com.cn.pojo.Pig"  name="pig2">
          <property name="name" value="猪猪侠"/>
    </bean>

    <bean class="com.cn.pojo.Pig"  name="pig">
          <property name="name" value="小猪猪"/>
    </bean>

    <bean class="com.cn.Service.ProviderService" id="providerService" autowire="byType">
          <property name="providerDao" ref="providerDao"/>
    </bean>

    <bean class="com.cn.dao.ProviderDao" id="providerDao">

    </bean>



</beans>
```



- byType：按照数据类型注入

- byName：按照bean对应的pojo（这里是User.class里的pig）里面的属性的名字来进行匹配

- byConstructor：

  + 优先按照类型name去匹配，如果匹配到一个bean那么直接注入无论name的值是什么，如果一个都没有就没注入

    ![1564126599008](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564126599008.png)

- default

- none：就是不注入

byType是根据类型进行注入它的属性，此时在上下文当中搜寻Pig这种bean，找到有且仅有一个的情况下，将会注入成功，如果一个都没有，没注入，如果不知一个，将会有异常

![1564125211127](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1564125211127.png)



## 常用注解

- component(强调是一个组件，在不好分为MVC中的那一层时用这个注解)
- controller(springMVC，强调控制层，控制层用这个注解)
- service(业务层，强调处理业务层，业务层用这个注解)
- repository（dao层，强调处理数据访问层，数据层用这个注解）

## 零碎的知识点

- 如何引入外部properties文件

  ```xml
  <!--通过这种方式引入我们路径下的文件-->
      <context:property-placeholder location="classpath:jdbc.properties"/>
  ```

  

- 如何通过表达式引用外部properties的键值

  ```xml
   <bean class="com.cn.dao.ProviderDao" id="providerDao1">
          <!--${}表达式可以去引用我们引入的这些properties里面的属性的值通过它的键名得到值-->
          <property name="driver" value="${driver}"/>
          <property name="url" value="${url}"/>
          <property name="user" value="${user}"/>
          <property name="password" value="${password}"/>
      </bean>
  ```

  

- 用一个.xml文件整合多个.xml文件

  ```xml
  <import resource="classpath:spring/spring-*"></import>
  ```

  

- 配置扫描包

  ```xml
  <!--扫描和激活注解
          扫描包是扫描该包以及子包的所有
      -->
      <context:component-scan base-package="com.cn.Service">
          <!--排除@repository-->
          <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
  
      </context:component-scan>
  ```

  

- 常问的spring面试题：beanfactory与applicationContext之间的区别

  

  

  

  

  

  

  

  