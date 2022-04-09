import compzx.Application;
import compzx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testFindAll() {
        userService.findAllUser().forEach(user -> System.out.println("user === " + user));

//        System.out.println("================================");
//
//        userService.findAllUser().forEach(user -> System.out.println("user *** " + user));
    }
}
