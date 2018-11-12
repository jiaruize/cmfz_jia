package com.baizhi.service;

import com.baizhi.dao.GongkDao;
import com.baizhi.entity.Gongk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GongkServiceImpl implements GongkService{
    @Autowired
    private GongkDao gongkDao;
    @Override
    public void insert(Gongk gongk) {
        gongk.setId(UUID.randomUUID().toString());
        gongkDao.insert(gongk);
    }

    @Override
    public void delete(String id) {
        gongkDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Gongk> queryByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return gongkDao.queryByPage(start,rows);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long queryTotals() {
        return gongkDao.queryTotals();
    }
}
