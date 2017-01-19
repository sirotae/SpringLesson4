package lesson4.controllers;

import lesson4.dao.UserDao;
import lesson4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @GetMapping("/geteuser/{id}")
    public User getUser(@PathVariable int id) {
        return userDao.findUserById(id);
    }

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userDao.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateuser")
    public void updateUser(@RequestBody User user) {
        userDao.update(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public void User(@PathVariable int id) {
        userDao.remove(id);
    }
}
