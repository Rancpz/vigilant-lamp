package sdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("sdi/Spring.xml");
        DeptService deptService = (DeptService) context.getBean("deptService");
        deptService.save("刘涛");
    }
}
