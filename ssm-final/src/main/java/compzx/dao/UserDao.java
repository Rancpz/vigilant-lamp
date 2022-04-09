package compzx.dao;

import compzx.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAllUser();

    void saveUser(User user);

    void deleteUser(String id);

    User findOneUser(String id);

    void updateUser(User user);
}
