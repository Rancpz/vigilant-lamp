package compzx.service;

import compzx.entity.User;
import java.util.List;

import static com.alibaba.druid.sql.dialect.oracle.ast.expr.OracleSizeExpr.Unit.T;


public interface UserService {
    void deleteUser(String id);

    User findOneUser(String id);

    void updateUser(User user);

    void saveUser(User user);

    List<User> findAllUser();

    User loginUser(String id, String name);
}
