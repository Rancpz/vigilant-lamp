package compzx.Service;

import compzx.entity.User;

import java.util.List;

public interface UserService {
    void deleteUser(String id);

    User findOneUser(String id);

    void updateUser(User user);

    void saveUser(User user);

    List<User> findAllUser();
}
