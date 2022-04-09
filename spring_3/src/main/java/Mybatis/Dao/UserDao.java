package Mybatis.Dao;

import Mybatis.entity.User;
import com.alibaba.druid.sql.visitor.functions.Insert;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();

    void insertUser(User user);
//    void saveUser(User user);
}
