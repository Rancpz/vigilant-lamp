package compzx.controller;

import com.alibaba.fastjson.JSONObject;
import compzx.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/test1")
    public String test(HttpServletResponse response) throws IOException {
        User user1 = new User("12", "小黑", 19, new Date());
        User user2 = new User("22", "小白", 24, new Date());
        User user3 = new User("32", "小紫", 43, new Date());
        List<User> users = Arrays.asList(user1, user2, user3);
        String format = JSONObject.toJSONStringWithDateFormat(users, "yyyy-MM-dd");
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().println(format);
        return null;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public List<User> test2() {
        User user1 = new User("12", "小黑", 19, new Date());
        User user2 = new User("22", "小白", 24, new Date());
        User user3 = new User("32", "小紫", 43, new Date());
        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }

    @RequestMapping("/test3")
    public String test3(Model model) {
        System.out.println("======2===========");
        model.addAttribute("username", "tom");
        int i = 1 / 0;
        return "index"; // 视图对象  ===>  ModelAndView  模型视图对象
    }
}
