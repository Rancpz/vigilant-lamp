package compzx.service;

import org.springframework.stereotype.Service;
import compzx.util.User;

import java.util.List;

public interface UserService {
    void addUser(String username, String password, int power);
    User checkUser(String username, String password);
    List<User> findAllUser();
}
