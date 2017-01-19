package lesson4.dao;

import lesson4.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
    User findUserById(int id);
    User createUser(User user);
    void update(User user);
    void remove(User user);
    void remove(int id);

}
