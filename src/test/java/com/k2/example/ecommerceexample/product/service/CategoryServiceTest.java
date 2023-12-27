package com.k2.example.ecommerceexample.product.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.k2.example.ecommerceexample.product.dto.CategoryDto;
import com.k2.example.ecommerceexample.product.model.Category;
import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;
import com.k2.example.ecommerceexample.product.repository.CategoryRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository repository;

    @Test
    void testSave() {

        CategoryDto categoryRequestDto = new CategoryDto(UUID.randomUUID().toString(), "CARRO", "AUTOMOVEL", CategoryPrincipalEnum.ELECTRONIC.name(), LocalDateTime.now());

        CategoryDto categoryResponseDto = categoryService.save(categoryRequestDto);

        Optional<Category> category = repository.findByName("CARRO");

        assertThat(category.isPresent());

        assertThat(category.get().getPrincipal().equals(CategoryPrincipalEnum.ELECTRONIC));

        assertThat(categoryResponseDto.name().equals("CARRO"));
    }
}