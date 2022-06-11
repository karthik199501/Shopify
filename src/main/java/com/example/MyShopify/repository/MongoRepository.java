package com.example.MyShopify.repository;

import com.example.MyShopify.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;
import java.util.List;

import static com.example.MyShopify.Constants.ShopifyConstants.*;

@Repository
public class MongoRepository {

    @Autowired
    private MongoTemplate template;

    public List<Product> findProductById(BigInteger productID){
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(productID));
        return template.find(query, Product.class);
    }
}
