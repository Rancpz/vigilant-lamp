package compzx.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("init/spring.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println("userDap = " + userDao);
        userDao.save("liuh");
    }
}
