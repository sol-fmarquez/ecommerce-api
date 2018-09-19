package com.amazon.ecommerceapi.services;

import com.amazon.ecommerceapi.domain.Product;
import com.amazon.ecommerceapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAllProducts() {

        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product findProduct(Integer productId) {

        Optional<Product> productRetrieved = productRepository.findById(productId);
        Product product = productRetrieved.get();
        return product;
    }

    public Product saveProduct(Product product) {

        return productRepository.save(product);

    }

    public void deleteProduct(Integer productId) {

        productRepository.deleteById(productId);
    }
}
