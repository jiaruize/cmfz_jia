package com.baizhi.service;

import com.baizhi.dao.YuserDao;
import com.baizhi.entity.Yuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class YuserServiceImpl implements YuserService {
    @Autowired
    private YuserDao yuserDao;
    @Override
    public void insert(Yuser yuser) {
        yuser.setId(UUID.randomUUID().toString());
        yuserDao.insert(yuser);
    }

    @Override
    public void update(Yuser yuser) {
        yuserDao.update(yuser);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Yuser queryOne(Yuser yuser) {
        Yuser queryOne = yuserDao.queryOne(yuser);
        if(queryOne!=null){
            System.out.println("登陆成功");
            return queryOne;
        }else{
            System.out.println("登陆不成功");
            return null;
        }

    }
}

