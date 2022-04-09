package compzx.controller;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @RestController springmvc以及SpringBoot 基于REST原则提供的新注解
 * 作用等同于 @Controller + @ResponseBody的组合
 * 标识当前服务是基于RESTFul架构风格
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("finAll")
    public String findAll(){ return "success"; }

    /**
     * Rest设计原则：
     * 1 用rest风格的url来替换传统的url
     *   restUrl：http://localhost:8989/user/findOne/1/
     * 2 使用四种Http动词来发起不同的操作
     * @GetMapping GET 查询
     * @PostMapping POST 新增
     * @PutMapping PUT 修改
     * @DeleteMapping DELETE 删除
     * 3 服务返回的都是json | xml 格式的数据
     */

    @GetMapping("findOne/{id}")
    public String findOne(@PathVariable("id") String id){
        System.out.println(id);
        return "findOne";
    }
    @PostMapping("save/{id}")
    public String save(@PathVariable("id") String id) {
        return "save";
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable("id") String id) {
        return "update";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        return "delete";
    }
}
