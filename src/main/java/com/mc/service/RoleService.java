package com.mc.service;

import com.mc.dao.RoleDao;
import com.mc.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Resource
    private RoleDao rd;

    public List<Role> findAllRole(){
        return rd.findAllRole();
    }

    public void savaRole(Role role) {
        rd.addRole(role);
    }

    public void deleteRole(ArrayList<Integer> data) {
        rd.deleteRole(data);
    }

    public void updateRole(Role role) {
        rd.updateRole(role);
    }

    @Transactional
    public void fenpei(Map<String, Object> data) {

        rd.deleteRoleRes(data.get("rid"));
        rd.fenpei(data);
    }
}
