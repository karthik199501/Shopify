package com.example.MyShopify.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;

public interface ShopifyAdminService {
    JSONObject get(String url);

    String saveAllProductsFromAdmin();

    JSONObject getProductCount();

    JSONObject getShopInfo();
}
