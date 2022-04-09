package cdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("cdi/srping.xml");
        AdminDao adminDao = (AdminDao) context.getBean("adminDao");
        adminDao.save("liuh");
    }
}
