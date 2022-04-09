package compzx.Service;

import compzx.dao.UserDao;
import compzx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    private static UserDao userDao;
//    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//    private UserDao userDao = (UserDao) context.getBean("userDao");

    @Autowired
    public void setUserDao(UserDao userDao) {
        UserServiceImpl.userDao = userDao;
    }
    //！！！！！！重要！！！！！
    // 由于未知原因，直接注入userDao会为null，所以此处需要通过setUserDao来自动注入


    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User findOneUser(String id) {
        return userDao.findOneUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
