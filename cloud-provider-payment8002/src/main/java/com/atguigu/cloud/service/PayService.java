package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

public interface PayService {

    public int add(Pay pay);
    int delete(Integer id);
    int update(Pay pay);
    Pay getPayById(Integer id);

    List<Pay> getPayList();

}
