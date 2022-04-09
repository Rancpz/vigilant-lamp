package compzx.service;

import compzx.dao.UserDao;
import compzx.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
