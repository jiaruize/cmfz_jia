package com.baizhi.service;

import com.baizhi.entity.Yuser;

public interface YuserService {
    void insert(Yuser yuser);
    void update(Yuser yuser);
    Yuser queryOne(Yuser yuser);
}
