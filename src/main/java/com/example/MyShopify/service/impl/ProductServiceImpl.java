package com.example.MyShopify.service.impl;

import com.example.MyShopify.entity.Product;
import com.example.MyShopify.repository.MongoRepository;
import com.example.MyShopify.repository.ProductsRepository;
import com.example.MyShopify.service.ProductService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private MongoRepository mongoRepository;

    @Override
    public List<Product> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Slice<Product> paginatedProducts(int page, int size) {
        return productsRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Document> findSelected(int page, int size){
        return productsRepository.findSelectedFields(PageRequest.of(page, size));
    }

    @Override
    public List<Product> findById(BigInteger id){
      return mongoRepository.findProductById(id);
    }
}
