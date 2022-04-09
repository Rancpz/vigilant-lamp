package pzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hello")
    public String HelloController() {
        System.out.println("hello controller");
        return "home";
    }

    @RequestMapping("/test1")
    public String Test1() {
        System.out.println("test1");
        return "redirect:/home.jsp";
    }

    @RequestMapping("/test2")
    public String Test2() {
        System.out.println("test2");
        return "redirect:/user/test1";
    }

    @RequestMapping("/test3")
    public String Test3(User user) {
        System.out.println(user.toString());
        return "home";
    }

    @RequestMapping("/test4")
    public String Test4(HttpServletRequest request, HttpServletResponse response) {
        String name = "gege";
        User user = new User(123, "qwe", new Date());
        User user1 = new User(155, "qadasde", new Date());
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        request.setAttribute("name", name);
        request.setAttribute("user", user);
//        request.setAttribute("list",list);
        request.setAttribute("list", list);
        return "attribute";
    }
}
