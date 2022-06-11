package com.example.MyShopify.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Variants {

    private BigInteger id;
    private String title;
    private String price;
    private String compare_at_price;
    private BigInteger inventory_item_id;
    private BigInteger inventory_quantity;
    private Boolean requires_shipping;

    public Variants(){

    }

    public Variants(BigInteger id,
                    String title,
                    String price,
                    String compare_at_price,
                    BigInteger inventory_item_id,
                    BigInteger inventory_quantity,
                    Boolean requires_shipping) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.compare_at_price = compare_at_price;
        this.inventory_item_id = inventory_item_id;
        this.inventory_quantity = inventory_quantity;
        this.requires_shipping = requires_shipping;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCompare_at_price() {
        return compare_at_price;
    }

    public void setCompare_at_price(String compare_at_price) {
        this.compare_at_price = compare_at_price;
    }

    public BigInteger getInventory_item_id() {
        return inventory_item_id;
    }

    public void setInventory_item_id(BigInteger inventory_item_id) {
        this.inventory_item_id = inventory_item_id;
    }

    public BigInteger getInventory_quantity() {
        return inventory_quantity;
    }

    public void setInventory_quantity(BigInteger inventory_quantity) {
        this.inventory_quantity = inventory_quantity;
    }

    public Boolean getRequires_shipping() {
        return requires_shipping;
    }

    public void setRequires_shipping(Boolean requires_shipping) {
        this.requires_shipping = requires_shipping;
    }

    @Override
    public String toString() {
        return "Variants{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", compare_at_price='" + compare_at_price + '\'' +
                ", inventory_item_id=" + inventory_item_id +
                ", inventory_quantity=" + inventory_quantity +
                ", requires_shipping=" + requires_shipping +
                '}';
    }

}
