package compzx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import compzx.dao.UserDao;
import compzx.util.User;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public UserServiceImpl() {
    }


    @Override
    public void addUser(String username, String password, int power) {
        userDao.addUser(username,password,power);
    }

    @Override
    public User checkUser(String username, String password) {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
