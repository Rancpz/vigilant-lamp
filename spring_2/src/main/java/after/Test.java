package after;

import before.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("after/spring.xml");
        AdminService adminService = (AdminService) context.getBean("adminServiceImpl");
        adminService.save("胡烨");
        adminService.findOne("12");
    }
}
