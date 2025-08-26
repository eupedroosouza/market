package io.github.eupedroosouza.market.product.controller;

import io.github.eupedroosouza.market.product.dto.CreateProductDTO;
import io.github.eupedroosouza.market.product.model.Product;
import io.github.eupedroosouza.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProducts(){
        return ResponseEntity.ok(productService.listProducts());
    }

    @GetMapping("{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") UUID productId) {
        return productService.findById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDTO createProductDTO) {
        return ResponseEntity.ok(productService.createProduct(createProductDTO));
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable("productId") UUID productId) {
        productService.deleteProduct(productId);
    }

}
