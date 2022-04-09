package compzx.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public String save(String name) {
        System.out.println("userDao" + name);
        return null;
    }
}
