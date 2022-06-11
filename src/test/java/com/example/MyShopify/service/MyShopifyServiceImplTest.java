package com.example.MyShopify.service;

import com.example.MyShopify.entity.Shopify;
import com.example.MyShopify.repository.ShopifyRepository;
import com.example.MyShopify.service.impl.MyShopifyServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class MyShopifyServiceImplTest {

    @Mock
    private ShopifyRepository shopifyRepository;
    @InjectMocks
    private MyShopifyServiceImpl myShopifyServiceImpl;

    @Test
    public void findAllProductsTest(){
        Shopify shopify = new Shopify(null, 50, Collections.emptyList());
        List<Shopify> shopifyList = new ArrayList<>();
        shopifyList.add(shopify);
        Mockito.when(myShopifyServiceImpl.findAllProducts()).thenReturn(shopifyList);
        shopifyList = myShopifyServiceImpl.findAllProducts();
        Assertions.assertEquals(1, shopifyList.size());
        Assertions.assertEquals(50, shopifyList.get(0).getProductCount());
    }
}
