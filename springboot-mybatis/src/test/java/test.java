import com.alibaba.fastjson.JSONObject;

import compzx.service.UserService;
import org.junit.Test;
import compzx.service.UserServiceImpl;
public class test {
    @Test
    public void e(){
//        User user = new User("929", "qwewqe", 33, new Date());
        UserService userService = new UserServiceImpl();
        userService.findAllUser();
        //userService.updateUser(user);
    }
}
