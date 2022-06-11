package com.example.MyShopify.service;

import com.example.MyShopify.entity.Shopify;

import java.util.List;

public interface MyShopifyService {
    List<Shopify> findAllProducts();
    String deleteAllProducts();
}
