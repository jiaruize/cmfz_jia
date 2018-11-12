package com.baizhi.service;

import com.baizhi.entity.Gongk;

import java.util.List;

public interface GongkService {
    void insert(Gongk gongk);
    void delete(String id);
    List<Gongk> queryByPage(Integer page, Integer rows);
    //查询总页数 Totals
    Long queryTotals();
}
