package com.library.service;

import com.library.entity.Product;
import com.library.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> searchProducts(String category, String ramSize, String hardDisk, 
                                        String cpuSpeed, String operatingSystem) {
        return productRepository.searchProducts(category, ramSize, hardDisk, cpuSpeed, operatingSystem);
    }
}
