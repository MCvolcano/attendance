package com.mc.controller;

import com.mc.entity.Resources;
import com.mc.entity.User;
import com.mc.service.ResService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ResController {

    @Resource
    private ResService rs;

    @RequestMapping("findAllRes")
    public List<Resources> findAllRes(HttpSession session) {

        User user = (User) session.getAttribute("user");
        return rs.findAllRes(user.getUid());
    }

    @RequestMapping("findAllResForRole")
    public List<Resources> findAllResForRole(int rid){

        System.out.println("rid" + rid);
        return rs.finAllResForRole(rid);
    }

    @RequestMapping("findRes")
    public String findRes() {
        return rs.findRes();
    }

    @RequestMapping("saveRes")
    @ResponseBody
    public String saveRes(Resources resources) {

        int rrid = resources.getRrid();
        if (rrid != 0) {
            rs.updateRes(resources);
        } else {
            rs.savaRes(resources);
        }
        return "1";
    }

    //  删除用户，传递数组数据，
    @RequestMapping("deleteRes")
    public String deleteRes(int rrid) {
        rs.deleteRes(rrid);

        return "1";
    }
}

