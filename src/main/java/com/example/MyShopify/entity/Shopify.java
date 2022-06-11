package com.example.MyShopify.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Shopify")
public class Shopify {
    @Id
    private String id;
    private ShopifyInfo shop_info;
    private int product_count;
    private List<Product> products;

    public Shopify(ShopifyInfo shop_info, int product_count, List<Product> products) {
        this.shop_info = shop_info;
        this.product_count = product_count;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShopifyInfo getShop_info() {
        return shop_info;
    }

    public void setShop_info(ShopifyInfo shop_info) {
        this.shop_info = shop_info;
    }

    public int getProductCount() {
        return product_count;
    }

    public void setProductCount(int product_count) {
        this.product_count = product_count;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Shopify{" +
                "id=" + id +
                ", shop_info=" + shop_info +
                ", product_count=" + product_count +
                ", products=" + products +
                '}';
    }

}
