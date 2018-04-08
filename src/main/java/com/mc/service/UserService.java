package com.mc.service;

import com.mc.dao.UserDao;
import com.mc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：马灿
 * @Description:
 * @Date: 下午 2:04 2018-02-06
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public int getCount() {
        return userDao.getCount();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user.getUid());
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }
}
