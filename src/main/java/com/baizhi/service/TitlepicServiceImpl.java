package com.baizhi.service;

import com.baizhi.dao.TitlepicDao;
import com.baizhi.entity.Titlepic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TitlepicServiceImpl implements TitlepicService {
    @Autowired
    private TitlepicDao titlepicDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Titlepic> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return titlepicDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return titlepicDao.queryTotals();
    }

    @Override
    public void delete(String id) {
        titlepicDao.delete(id);
    }

    @Override
    public void insert(Titlepic titlepic) {
        titlepic.setId(UUID.randomUUID().toString());
        titlepicDao.insert(titlepic);
    }

    @Override
    public void update(Titlepic titlepic) {
        titlepicDao.update(titlepic);
    }

    @Override
    public Titlepic queryOne(Titlepic titlepic) {
        Titlepic queryOne = titlepicDao.queryOne(titlepic);
        return queryOne;
    }


}
