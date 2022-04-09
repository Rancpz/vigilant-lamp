package compzx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import compzx.entity.User;
import compzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("my")
@CrossOrigin
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/findOne")
//    public String findOneUser(String id, HttpServletRequest request) {
//        User user = userService.findOneUser(id);
//        request.setAttribute("user", user);
//        return "showAll";
//    }
//    @RequestMapping("save")
//    public String saveUser(User user) {
//        userService.saveUser(user);
//        return "showAll";
//    }
//    @RequestMapping("update")
//    @ResponseBody
//    public String updateUser(User user) {
//        userService.updateUser(user);
//        return "redirect:/my/findAll";
//    }
//    public String deleteUser(String id) {
//        userService.deleteUser(id);
//        return "redirect:/my/findAll";
//    }
//    @RequestMapping("findAll")
//    public String findAllUser(Model model) {
//        List<User> users = userService.findAllUser();
//        model.addAttribute("users", users);
//        return "showAll";
//    }原有
    @RequestMapping("findAll")
    public String findAllUser(HttpServletResponse response) {
        List<User> users = userService.findAllUser();
        String jsonString = JSONObject.toJSONString(users);
        //System.out.println(users.get(1).toString());
        return jsonString;
    }

    @RequestMapping("save")
    public void saveUser(@RequestBody User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        //return "showAll";
    }

    @RequestMapping("/findOne")
    public String findOneUser(String id, HttpServletRequest request) {
        User user = userService.findOneUser(id);
        request.setAttribute("user", user);
        return JSONObject.toJSONString(user);
        //return "showAll";
    }

    @RequestMapping("delete")
    public void deleteUser(String id) {
        userService.deleteUser(id);
//        return "delete Success";
//        userService.deleteUser(id);
//        return "redirect:/my/findAll";
    }

    @RequestMapping("update")
    public void updateUser(@RequestBody User user) {
        //date类型需要特别注意
        System.out.println(user.toString());
        userService.updateUser(user);
       // System.out.println("修改成功" + user.toString());
        //return "update success";
//        userService.updateUser(user);
//        return "redirect:/my/findAll";
    }

    @RequestMapping("login")
    public String loginUser(@RequestBody User user) {
        User user1 = userService.loginUser(user.getId(), user.getName());
        return JSONObject.toJSONString(user1);
    }
}
