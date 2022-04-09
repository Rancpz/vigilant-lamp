package compzx.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("di/spring.xml");
//        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
//        studentDao.save("小黑");
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.save("小黑");
    }
}
