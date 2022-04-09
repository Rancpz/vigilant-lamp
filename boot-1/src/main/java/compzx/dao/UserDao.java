package compzx.dao;

import compzx.util.User;

import java.util.List;

public interface UserDao {
    void addUser(String username, String password, int power);
    User checkUser(String username, String password);
    List<User> findAllUser();
}
