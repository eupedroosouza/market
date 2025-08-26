package io.github.eupedroosouza.market.product.service;

import io.github.eupedroosouza.market.product.dto.CreateProductDTO;
import io.github.eupedroosouza.market.product.model.Product;
import io.github.eupedroosouza.market.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    public Product createProduct(final CreateProductDTO createProductDTO) {
        Product product = new Product();
        product.setName(createProductDTO.name());
        product.setImageUrl(createProductDTO.imageUrl());
        product.setDescription(createProductDTO.description());
        product.setPrice(createProductDTO.price());
        return productRepository.save(product);
    }

    public void deleteProduct(final UUID id) {
        productRepository.deleteById(id);
    }

}
