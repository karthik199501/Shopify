package com.example.MyShopify.entity;

public class ShopifyInfo {

    public String name;
    public String domain;

    public ShopifyInfo(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "ShopifyInfo{" +
                "name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
