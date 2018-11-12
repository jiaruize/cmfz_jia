package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDao albumDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return albumDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return albumDao.queryTotals();
    }

    @Override
    public void insert(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> queryAll() {
        List<Album> queryAll = albumDao.queryAll();
        return queryAll;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album findOne(String id) {
        Album queryOne = albumDao.findOne(id);
        return queryOne;
    }



}
