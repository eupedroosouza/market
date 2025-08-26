package io.github.eupedroosouza.market.product.dto;

import java.math.BigDecimal;

public record CreateProductDTO(String name, String imageUrl, String description, BigDecimal price) {
}
