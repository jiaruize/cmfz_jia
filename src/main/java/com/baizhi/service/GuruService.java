package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> findByPage(Integer page, Integer rows);

    Long findTotals();
    void delete(String id);
    void insert(Guru guru);

}
