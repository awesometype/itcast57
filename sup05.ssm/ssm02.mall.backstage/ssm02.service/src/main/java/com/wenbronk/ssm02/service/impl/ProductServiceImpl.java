package com.wenbronk.ssm02.service.impl;

import com.wenbronk.ssm02.dao.ProductDao;
import com.wenbronk.ssm02.domain.Product;
import com.wenbronk.ssm02.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        System.out.println("hello service");
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
