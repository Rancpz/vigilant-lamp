package factorybean;

import org.apache.ibatis.javassist.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);
        ApplicationContext context = new ClassPathXmlApplicationContext("factorybean/spring.xml");
        Calendar calendar = (Calendar) context.getBean("calendar");
        Calendar calendar1 = (Calendar) context.getBean("calendar");
        System.out.println(calendar);
        System.out.println(calendar1);
        System.out.println(calendar == calendar1);
    }
}
