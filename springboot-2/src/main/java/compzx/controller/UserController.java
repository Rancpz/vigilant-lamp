package compzx.controller;

import compzx.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("test")
    @ResponseBody
    public String findAll() {
        log.info("$$$log$$$$");
        User user = new User();
        user.setName("xiaohao");
        System.out.println(user);
        System.out.println("========进入方法==========");
        return "index";
    }
}
