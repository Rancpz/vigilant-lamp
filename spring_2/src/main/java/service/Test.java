package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pzx/spring.xml");
        UserServiceStaticProxy userService = (UserServiceStaticProxy) context.getBean("userServiceStaticProxy");
        userService.save("哈哈");
    }
}
