package com.mc.dao;


import com.mc.entity.Res;
import com.mc.entity.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ResDao {
    List<Resources> findAllRes(int uid);

    List<Resources> findAllResForRole();

    List<Res> findRes();

    List<Resources> findResForRole(int rid);

    void updateRes(Resources resources);

    void saveRes(Resources resources);

    void deleteRes(int data);
}
