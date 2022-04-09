package compzx.controller;

import compzx.service.UserService;
import compzx.util.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    UserService userService = (UserService) ac.getBean("Service");
    @RequestMapping("/test1")
    public String test1(){
        return "home";
    }

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request){
        List<User> list = userService.findAllUser();
        request.setAttribute("list",list);
        return "User";
    }
}
