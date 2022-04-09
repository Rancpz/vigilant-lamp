package compzx.controller;

import compzx.Service.UserService;
import compzx.Service.UserServiceImpl;
import compzx.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/tt")
public class controller {

    @RequestMapping("/find")
    public String findAllUser(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl();
        List<User> list = userService.findAllUser();
        request.setAttribute("list", list);
        return "showAll";
    }

    @RequestMapping("save")
    public String saveUser(User user) {
        System.out.println("user = " + user);
        UserService userService = new UserServiceImpl();
        userService.saveUser(user);
        return "showAll";
    }

    @RequestMapping("/findOne")
    public String findOneUser(String id, HttpServletRequest request) {
        UserService userService = new UserServiceImpl();
        User user = userService.findOneUser(id);
        //System.out.println(userService.findOneUser("123").toString());
        request.setAttribute("user", user);
        return "showAll";
    }

    @RequestMapping("delete")
    public String deleteUser(String id) {
        UserService userService = new UserServiceImpl();
        userService.deleteUser(id);
        return "redirect:/tt/find";
    }

    @RequestMapping("update")
    public String updateUser(User user) {
        UserService userService = new UserServiceImpl();
        userService.updateUser(user);
        return "redirect:/tt/find";
    }
}
