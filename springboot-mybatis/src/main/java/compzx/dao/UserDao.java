package compzx.dao;

import compzx.entity.User;

import java.util.List;
public interface UserDao {
    List<User> findAllUser();

    void saveUser(User user);

    void deleteUser(String id);

    User findOneUser(String id);

    void updateUser(User user);

    User loginUser(String id, String name);
}
