package com.example.MyShopify.service;

import com.example.MyShopify.entity.Product;
import org.bson.Document;
import org.springframework.data.domain.Slice;

import java.math.BigInteger;
import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Slice<Product> paginatedProducts(int page, int size);

    List<Document> findSelected(int page, int size);

    List<Product> findById(BigInteger id);
}


