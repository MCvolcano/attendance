package com.mc.dao;

import com.mc.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RoleDao {

    List<Role> findAllRole();

    void addRole(Role role);

    void deleteRole(ArrayList<Integer> ids);

    void updateRole(Role role);

    void fenpei(Map<String, Object> data);

    void deleteRoleRes(Object rid);
}
