package com.baizhi.service;

import com.baizhi.entity.Titlepic;

import java.util.List;

public interface TitlepicService {
    List<Titlepic> findByPage(Integer page, Integer rows);

    Long findTotals();

    void delete(String id);
    void insert(Titlepic titlepic);
    void update(Titlepic titlepic);
    Titlepic queryOne(Titlepic titlepic);

}
