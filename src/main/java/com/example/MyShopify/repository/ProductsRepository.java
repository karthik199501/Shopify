package com.example.MyShopify.repository;

import com.example.MyShopify.entity.Product;
import org.bson.Document;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductsRepository extends MongoRepository<Product, String>,
        PagingAndSortingRepository<Product, String> {

    @Query(value = "{}", fields = "{_id : 0, title : 1, status : 1, variants : 1}")
    List<Document> findSelectedFields(PageRequest pageable);

}
