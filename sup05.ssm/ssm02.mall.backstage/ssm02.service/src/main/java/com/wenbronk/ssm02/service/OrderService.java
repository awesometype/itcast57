package com.wenbronk.ssm02.service;

import com.wenbronk.ssm02.domain.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll(int page, int pageSize);

    Orders findById(String id);
}
