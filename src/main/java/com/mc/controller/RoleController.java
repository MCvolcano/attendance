package com.mc.controller;

import com.mc.entity.Role;
import com.mc.service.RoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Resource
    private RoleService rs;


    @RequestMapping("findAllRole")
    @ResponseBody
    public List<Role> findAllRole() {

        List<Role> list = rs.findAllRole();

        return list;
    }

    @RequestMapping("saveRole")
    @ResponseBody
    public String saveRole(Role role) {

        int id = role.getRid();
        if (id != 0) {
            rs.updateRole(role);
        } else {
            rs.savaRole(role);
        }

        return "1";
    }


//  删除用户，传递数组数据，
    @RequestMapping("deleteRole")
    public String deleteRole(@RequestBody ArrayList<Integer> data) {
        rs.deleteRole(data);
        return "1";
    }


    @RequestMapping("fenpei")
    public String fenpei(@RequestBody ArrayList<Integer> args) {

        Map<String, Object> data = new HashMap<>();
        data.put("rid", args.get(0));
        args.remove(0);
        data.put("ps",args);

        rs.fenpei(data);
        return "1";

    }
}
