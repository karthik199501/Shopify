package com.example.MyShopify.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static com.example.MyShopify.Constants.ShopifyConstants.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class ShopifyAdminServiceImplTest {

    @Autowired
    private ShopifyAdminService shopifyAdminService;
    @Autowired
    private MyShopifyService myShopifyService;

    @Before
    public void beforeTests() {
        //clean up before
        deleteAll();
    }

    @Test
    public void saveAllProductsFromAdminTest() {
        //Should return saved success message as database is empty
        String result = shopifyAdminService.saveAllProductsFromAdmin();
        Assertions.assertEquals(result, SUCCESSFULLY_SAVED);

        //Should return already message as products are already saved
        result = shopifyAdminService.saveAllProductsFromAdmin();
        Assertions.assertEquals(result, ALREADY_SAVED);
    }

    @Test
    public void getShopInfoTest() {
        //fetching Shop info from Shopify Admin
        JSONObject jsonObject = shopifyAdminService.getShopInfo();
        boolean result = jsonObject.isEmpty();
        Assertions.assertFalse(result);
    }

    @Test
    public void getProductCountTest() {
        //fetching Shop info from Shopify Admin
        JSONObject jsonObject = shopifyAdminService.getProductCount();
        boolean result = jsonObject.isEmpty();
        Assertions.assertFalse(result);
    }

    @After
    public void afterTests(){
        //clean up after
        deleteAll();
    }

    private void deleteAll(){
        myShopifyService.deleteAllProducts();
    }

}


