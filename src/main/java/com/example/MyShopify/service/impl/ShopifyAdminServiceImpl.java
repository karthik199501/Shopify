package com.example.MyShopify.service.impl;

import com.example.MyShopify.Constants;
import com.example.MyShopify.entity.*;
import com.example.MyShopify.repository.ProductsRepository;
import com.example.MyShopify.repository.ShopifyRepository;
import com.example.MyShopify.service.ProductService;
import com.example.MyShopify.service.ShopifyAdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MyShopify.Constants.ShopifyConstants.*;

@Service
public class ShopifyAdminServiceImpl implements ShopifyAdminService {

    public static final Logger log = LoggerFactory.getLogger(ShopifyAdminServiceImpl.class);
    @Value("${shopify.api.url}")
    private String url;
    @Value("${shopify.access.token}")
    private String token;
    @Autowired
    private ShopifyRepository shopifyRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductService productService;

    @Override
    public JSONObject get(String path) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(url + path)
                    .header(Constants.CONTENT_TYPE, Constants.JSON_TYPE)
                    .header(Constants.ACCESS_TOKEN, token)
                    .asJson();
        } catch (UnirestException e) {
            log.error("Unable to fetch response from Shopify Admin");
        }
        if (response != null) {
            return response.getBody().getObject();
        }
        return null;
    }

    @Override
    public String saveAllProductsFromAdmin() {
        Shopify shopify;
        ShopifyInfo shopifyInfo;
        List<Product> productList;
        ObjectMapper objectMapper = new ObjectMapper();
        /*Check if database is empty if true fetch from Admin
         else return "Products are already saved from Shopify Admin"
         */
        try {
            if (fetchAllProducts().isEmpty()) {
                String adminAllProducts = Constants.PATH_PRODUCTS;
                JSONObject productsResult = get(adminAllProducts);
                JSONObject shopInfoResult = getShopInfo();
                JSONObject productCountResult = getProductCount();

                JSONArray productsArray = productsResult.getJSONArray(PRODUCTS);
                JSONObject shopInfo = shopInfoResult.getJSONObject(SHOP);
                int productCount = productCountResult.getInt(COUNT);

                productList = objectMapper.readValue(productsArray.toString(), new TypeReference<List<Product>>() {
                });
                shopifyInfo = new ShopifyInfo(shopInfo.getString(NAME), shopInfo.getString(DOMAIN));
                shopify = new Shopify(shopifyInfo, productCount, productList);
                //Saving All Products
                productsRepository.saveAll(productList);
                //Saving Shopify store
                shopifyRepository.save(shopify);
                return SUCCESSFULLY_SAVED;
            } else {
                return ALREADY_SAVED;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Cacheable("product-count")
    @Override
    public JSONObject getProductCount() {
        String adminProductCount = Constants.PATH_PRODUCT_COUNT;
        log.info("Fetching product count from Shopify Admin");
        return get(adminProductCount);
    }

    @Override
    public JSONObject getShopInfo() {
        String path = Constants.SHOP_INFO;
        log.info("Fetching Shop Info");
        return get(path);
    }

    private List<Product> fetchAllProducts() {
        return productService.findAllProducts();
    }
}
