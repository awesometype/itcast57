package com.wenbronk.ssm02.service;

import com.wenbronk.ssm02.domain.Product;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-21
 */
public interface ProductService {

    List<Product> findAll();

    void save(Product product);
}
