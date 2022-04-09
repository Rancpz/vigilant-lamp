package compzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("js")
public class JspController {

    @RequestMapping("test1")
    public String test1() {
        return "index";
    }
}
