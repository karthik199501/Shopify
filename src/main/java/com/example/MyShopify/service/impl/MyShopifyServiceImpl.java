package com.example.MyShopify.service.impl;

import com.example.MyShopify.entity.Shopify;
import com.example.MyShopify.repository.ProductsRepository;
import com.example.MyShopify.repository.ShopifyRepository;
import com.example.MyShopify.service.MyShopifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MyShopify.Constants.ShopifyConstants.*;

@Service
public class MyShopifyServiceImpl implements MyShopifyService {

    @Autowired
    ShopifyRepository shopifyRepository;
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Shopify> findAllProducts() {
        return shopifyRepository.findAll();
    }

    @Override
    public String deleteAllProducts() {
        shopifyRepository.deleteAll();
        productsRepository.deleteAll();
        return DELETED_SUCCESSFULLY;
    }
}
