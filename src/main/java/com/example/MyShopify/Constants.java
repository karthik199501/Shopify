package com.example.MyShopify;

public class Constants {

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON_TYPE = "application/json";
    public static final String ACCESS_TOKEN = "X-Shopify-Access-Token";

    public static final String PATH_PRODUCTS = "/products.json";
    public static final String PATH_PRODUCT_COUNT = "/products/count.json";
    public static final String SHOP_INFO = "/shop.json";

    public static class ShopifyConstants {
        public static final String PRODUCTS = "products";
        public static final String SHOP = "shop";
        public static final String COUNT = "count";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DOMAIN = "domain";
        public static final String SUCCESSFULLY_SAVED = "Successfully saved products from Shopify Admin";
        public static final String ALREADY_SAVED = "Products are already saved from Shopify Admin";
        public static final String DELETED_SUCCESSFULLY = "Shopify Store deleted successfully";
    }
}
