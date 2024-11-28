package com.codesnippet.ecom.Service;

import com.codesnippet.ecom.Entity.Product;
import com.codesnippet.ecom.Repository.ProductRepository;
import com.codesnippet.ecom.customAnnotations.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        System.out.println("ProductService Created");
    }

    public Product addProduct(Product product) {
        log.info("adding product in DB");
        boolean validation = validateProductName(product.getName());
        if(validation) {
            Product savedProduct = productRepository.save(product);
            return savedProduct;
        }
        else{
            throw new RuntimeException("Invalid Name Of Product");
        }

    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    private boolean validateProductName(String name) {
        return name != null && !name.isEmpty();
    }

    // Void method to demonstrate mocking of voids
    public void updateProductStock(Integer productId, int quantity) {
        log.info("Updating stock for product with ID: " + productId);

        Optional<Product> productOpt = productRepository.findById(productId);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            int newStock = product.getStock() + quantity; // Assuming Product entity has a 'stock' field
            product.setStock(newStock);  // Update the stock

            log.info("New stock level for product {}: {}", productId, newStock);
            productRepository.save(product);  // Save the updated product
        } else {
            log.warn("Product with ID: {} not found", productId);
        }
    }

}
