package com.baizhi.service;

import com.baizhi.dao.GuserDao;
import com.baizhi.entity.Guser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuserServiceImpl implements GuserService {
    @Autowired
    private GuserDao guserDao;
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Guser findOne(Guser guser) {
        Guser queryOne = guserDao.queryOne(guser);
        if(queryOne!=null){
            System.out.println("登陆成功");
            return queryOne;
        }else {
            System.out.println("登陆失败");
            return null;

        }
    }
    @Override
    public void update(Guser guser) {
        guserDao.update(guser);

    }

    @Override
    public Guser querypwd(String ypassword) {
        Guser querypwd = guserDao.querypwd(ypassword);
        return querypwd;
    }
}
