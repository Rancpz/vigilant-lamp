package Mybatis.Service;

import Mybatis.Dao.UserDao;
import Mybatis.entity.User;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private PlatformTransactionManager platformTransactionManager;


    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            userDao.insertUser(user);
            int i = 1 / 0;
            platformTransactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            platformTransactionManager.rollback(status);
        }
    }
}
