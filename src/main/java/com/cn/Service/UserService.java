package com.cn.Service;

import org.springframework.stereotype.Repository;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 22:07
 */
/*@Component注解：标记它为一个组件*/
/*@Component("userService_a")*/
/*如果没有命名就默认为UserService的前一个字母为小写userService*/
/*@Component*/
/*@Service*/
@Repository
public class UserService {

    public void eat(){
        System.out.println("吃了西瓜.....");
    }
}
