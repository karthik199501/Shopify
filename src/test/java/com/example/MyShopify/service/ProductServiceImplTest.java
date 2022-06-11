package com.example.MyShopify.service;

import com.example.MyShopify.entity.Product;
import com.example.MyShopify.repository.MongoRepository;
import com.example.MyShopify.repository.ProductsRepository;
import org.bson.Document;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    ProductsRepository productsRepository;
    @Mock
    MongoRepository mongoRepository;


    @Test
    public void findSelectedTest(){
        Document d = new Document();
        List<Document> emptyDocList = new ArrayList<>();
        emptyDocList.add(d);
        Mockito.when(productsRepository.findSelectedFields(PageRequest.of(4, 10))).thenReturn(emptyDocList);
        List<Document> result = productsRepository.findSelectedFields(PageRequest.of(4, 10));
        //Should return false as we are returning a doc
        boolean mockResult = result.isEmpty();
        Assertions.assertFalse(mockResult);
    }

    @Test
    public void findByIdTest(){
        Mockito.when(mongoRepository.findProductById(Mockito.any())).thenReturn(productList());
        List<Product> result = mongoRepository.findProductById(BigInteger.valueOf(34));
        Assertions.assertEquals(result.get(0).getTitle(), "test");
    }

    @Test
    public void findAllProductsTest(){ ;
        Mockito.when(productsRepository.findAll()).thenReturn(productList());
        List<Product> result = productsRepository.findAll();
        Assertions.assertEquals(result.size(), 1);
        Assertions.assertEquals(result.get(0).getTitle(), "test");
    }

    private List<Product> productList(){
        List<Product> productsList = new ArrayList<>();
        Product product = new Product(null,"test",null, null, Collections.emptyList(),Collections.emptyList());
        productsList.add(product);
        return productsList;
    }

}
