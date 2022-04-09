package adi;

import cdi.AdminDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("adi/spring.xml");
        TagService tagService = (TagService) context.getBean("tagService");
        tagService.save("lieu");
    }
}
