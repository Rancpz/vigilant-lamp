package before;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("before/spring.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.save("胡烨");

    }
}
