package service;

public interface UserService {
    void save(String name);

    void delete(String id);

    void update(int id);

    String findAll(String name);

    String findOne(String name);
}
