package com.example.MyShopify.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Document(value = "Products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private BigInteger id;
    private String title;
    private String created_at;
    private String status;
    private List<Variants> variants;
    private List<Images> images;

    public Product(){

    }

    public Product(BigInteger id, String title, String created_at, String status, List<Variants> variants, List<Images> images) {
        this.id = id;
        this.title = title;
        this.created_at = created_at;
        this.status = status;
        this.variants = variants;
        this.images = images;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Variants> getVariants() {
        return variants;
    }

    public void setVariants(List<Variants> variants) {
        this.variants = variants;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id + '\'' +
                ", title='" + title + '\'' +
                ", created_at='" + created_at + '\'' +
                ", status='" + status + '\'' +
                ", variants=" + variants +
                ", images=" + images +
                '}';
    }
}
