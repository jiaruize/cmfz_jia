package com.baizhi.service;


import com.baizhi.entity.Guser;

public interface GuserService {
    Guser findOne(Guser guser);
    void update(Guser guser);
    Guser querypwd(String ypassword);

}
