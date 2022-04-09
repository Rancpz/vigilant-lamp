package Mybatis;

import Mybatis.Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/Mybatis/spring.xml");
//        SqlSessionFactory sessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
//        System.out.println(sessionFactory.openSession());
//        UserDao userDao = (UserDao) context.getBean("userDao");
//        userDao.findAllUser().forEach(user->System.out.println(user));
    }

}
