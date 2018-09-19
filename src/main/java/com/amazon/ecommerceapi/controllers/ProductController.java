package com.amazon.ecommerceapi.controllers;

import com.amazon.ecommerceapi.domain.Product;
import com.amazon.ecommerceapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("ecommerce/products")
    @ResponseBody
    public Product createProduct(@RequestBody Product product) {

        Product newProduct = productService.saveProduct(product);
        return newProduct;
    }

    @GetMapping("ecommerce/products")
    public List<Product> getProducts() {
        List<Product> products = productService.findAllProducts();
        return products;
    }

    @GetMapping("ecommerce/products/{id}")
    public Product getProduct(@PathVariable Integer id) {

        Product product = productService.findProduct(id);
        return product;
    }

    //@PutMapping

    @DeleteMapping("/ecommerce/products/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Account has been deleted successfully.");
    }
}
