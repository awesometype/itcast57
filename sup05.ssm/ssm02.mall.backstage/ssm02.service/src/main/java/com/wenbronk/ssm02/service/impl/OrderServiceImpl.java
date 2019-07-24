package com.wenbronk.ssm02.service.impl;

import com.github.pagehelper.PageHelper;
import com.wenbronk.ssm02.dao.OrderDao;
import com.wenbronk.ssm02.domain.Orders;
import com.wenbronk.ssm02.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-21
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> findAll(int page, int pageSize) {
        // 分页插件一定紧跟要分页的dao
        PageHelper.startPage(page, pageSize);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return orderDao.orderDao(id);
    }
}
