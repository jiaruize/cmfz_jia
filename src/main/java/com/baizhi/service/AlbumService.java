package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findByPage(Integer page, Integer rows);

    Long findTotals();
    void insert(Album album);
    List<Album> queryAll();
    Album findOne(String id);

}
