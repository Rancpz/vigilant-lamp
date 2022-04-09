package compzx.dao;

import compzx.entity.User;
import java.util.List;

public interface UserDao {
    List<User> findAllUser();
}
