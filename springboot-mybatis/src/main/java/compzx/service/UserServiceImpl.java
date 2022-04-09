package compzx.service;

import compzx.dao.UserDao;
import compzx.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
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

    @Override
    public User loginUser(String id, String name) {
        return userDao.loginUser(id, name);
    }
}
