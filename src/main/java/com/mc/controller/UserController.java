package com.mc.controller;

import com.mc.entity.User;
import com.mc.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：马灿
 * @Description:
 * @Date: 下午 2:05 2018-02-06
 */
@RestController
@RequestMapping("sys")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findAllUser")
    public Map<String, Object> findAll(@RequestParam("pageNumber") int page, @RequestParam("pageSize") int rows) {
        List<User> list = userService.findAll();
        int count = userService.getCount();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", count);
        return map;
    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "1";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User user) {
        userService.deleteUser(user);
        return "1";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "1";
    }

    @RequestMapping("/login")
    public String login(String account, String password) {
        User user = userService.findUserByAccount(account);
        if (account.equals(user.getAccount()) && password.equals(user.getPassword())) {
            return "1";
        }
        return "0";
    }



}
