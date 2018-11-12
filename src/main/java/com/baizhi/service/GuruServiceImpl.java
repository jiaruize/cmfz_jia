package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return guruDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return guruDao.queryTotals();
    }

    @Override
    public void delete(String id) {
        guruDao.delete(id);
    }

    @Override
    public void insert(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }
}
