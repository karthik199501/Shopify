package com.example.MyShopify.repository;

import com.example.MyShopify.entity.Shopify;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ShopifyRepository extends MongoRepository<Shopify, String> {

}


