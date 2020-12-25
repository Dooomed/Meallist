package com.prokhorenko.meallist.dao.service;

import com.prokhorenko.meallist.dao.UserDao;
import com.prokhorenko.meallist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findById(int id){
        return userDao.findUserById(id);
    }

    public List<User> findAll() {
        return userDao.getAll();
    }

    /*public User findByUsername(String username) {
        return (User) userDao.loadUserByUsername(username);
    }*/

    /*public boolean save(User user) {
        return userDao.createUser(user);
    }*/

    public void delete(User user) {
        userDao.deleteUser(user);
    }

    public void update(User user) {
        userDao.updateUser(user);
    }
}
