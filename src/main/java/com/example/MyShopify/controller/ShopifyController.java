package com.example.MyShopify.controller;

import com.example.MyShopify.entity.Product;
import com.example.MyShopify.entity.Shopify;
import com.example.MyShopify.repository.ProductsRepository;
import com.example.MyShopify.service.MyShopifyService;
import com.example.MyShopify.service.ProductService;
import com.example.MyShopify.service.ShopifyAdminService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


@RestController
@RequestMapping("/api/shopify")
public class ShopifyController {

    @Autowired
    MyShopifyService myShopifyService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    private ShopifyAdminService shopifyAdminService;


    @GetMapping(value = "/save/products-from-shopify-admin")
    public ResponseEntity<String> saveProductsFromShopify() {
        String response = shopifyAdminService.saveAllProductsFromAdmin();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch-shopify-store")
    public ResponseEntity<List<Shopify>> fetchAllProducts() {
        List<Shopify> response = myShopifyService.findAllProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch-paginated-products", params = {"page", "size"})
    public ResponseEntity<Slice<Product>> fetch(@RequestParam("page") int page,
                                                @RequestParam("size") int size) {
        Slice<Product> response = productService.paginatedProducts(page, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch-shop-info")
    public ResponseEntity<String> fetchShopInfo() {
        String response = shopifyAdminService.getShopInfo().toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch-product-count")
    public ResponseEntity<String> fetchProductCount() {
        String response = shopifyAdminService.getProductCount().toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/filter-product-by-id", params = {"id"})
    public ResponseEntity<List<Product>> filterProductById(@RequestParam("id") BigInteger id){
       List<Product> response = productService.findById(id);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch-all/title/status/variants", params = {"page", "size"})
    public ResponseEntity<List<Document>> findSelectedFields(@RequestParam("page") int page,
                                                           @RequestParam("size") int size){
        List<Document> response = productService.findSelected(page, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-all-products")
    public ResponseEntity<String> deleteAllProducts() {
        String response = myShopifyService.deleteAllProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

