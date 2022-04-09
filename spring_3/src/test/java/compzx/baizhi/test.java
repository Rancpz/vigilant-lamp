package compzx.baizhi;

import Mybatis.Dao.UserDao;
import Mybatis.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void ceshi1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Mybatis/spring.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        userDao.findAllUser().forEach(user -> {
            System.out.println(user.toString());
        });
    }
}
