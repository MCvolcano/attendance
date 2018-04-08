package com.mc.dao;

import com.mc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author：马灿
 * @Description:
 * @Date: 下午 1:59 2018-02-06
 */
@Repository
@Mapper
public interface UserDao {
    List<User> findAll();

    int getCount();
    
    void addUser(User user);
    
    void deleteUser(long id);
    
    void updateUser(User user);
    
    User findUserById(int id);

    User findUserByAccount(String account);
}
