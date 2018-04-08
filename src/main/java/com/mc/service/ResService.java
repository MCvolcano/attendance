package com.mc.service;

import com.mc.dao.ResDao;
import com.mc.entity.Res;
import com.mc.entity.Resources;
import com.mc.uitls.ToJsonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service
public class ResService {

    @Resource
    private ResDao rd;

    public List<Resources> findAllRes(int uid) {
        return rd.findAllRes(uid);
    }

    public List<Resources> finAllResForRole(int rid) {
        List<Resources> alllist = rd.findAllResForRole();
        List<Resources> list = rd.findResForRole(rid);

        for (Resources alll : alllist) {
            Iterator<Resources> iterator = alll.getChildren().iterator();
            while (iterator.hasNext()) {
                Resources next = iterator.next();
                Integer rrid = next.getRrid();

                //循环
                for (Resources ll :list) {
                    Iterator<Resources> li1 = ll.getChildren().iterator();
                    while (li1.hasNext()) {
                        Resources ln1 = li1.next();
                        if (rrid == ln1.getRrid()) {
                            next.setChecked(true);
                        }
                    }
                }

            }
        }
        return alllist;
    }

    public String findRes() {
        List<Res> data = rd.findRes();

        String s = ToJsonUtil.toJson(data);

        return s;
    }

    public void updateRes(Resources resources) {
        rd.updateRes(resources);
    }

    public void savaRes(Resources resources) {
        rd.saveRes(resources);
    }

    public void deleteRes(int rrid) {
        rd.deleteRes(rrid);
    }
}
