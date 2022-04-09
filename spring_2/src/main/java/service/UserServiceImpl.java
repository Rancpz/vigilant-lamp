package service;

public class UserServiceImpl implements UserService {

    @Override
    public void save(String name) {
        System.out.println("处理save业务逻辑，调用Dao");
    }

    @Override
    public void delete(String id) {
        System.out.println("处理delete业务逻辑，调用Dao");
    }

    @Override
    public void update(int id) {
        System.out.println("处理update业务逻辑，调用Dao");
    }

    @Override
    public String findAll(String name) {
        System.out.println("处理findAll业务逻辑，调用Dao");
        return name;
    }

    @Override
    public String findOne(String id) {
        System.out.println("处理findOne业务逻辑，调用Dao");
        return id;
    }
}