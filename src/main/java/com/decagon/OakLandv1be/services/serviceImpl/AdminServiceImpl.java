package com.decagon.OakLandv1be.services.serviceImpl;

import com.decagon.OakLandv1be.dto.ProductResponseDto;

import com.decagon.OakLandv1be.entities.Person;
import com.decagon.OakLandv1be.entities.Product;
import com.decagon.OakLandv1be.entities.SubCategory;
import com.decagon.OakLandv1be.exceptions.ProductNotFoundException;
import com.decagon.OakLandv1be.exceptions.ResourceNotFoundException;
import com.decagon.OakLandv1be.repositries.AdminRepository;
import com.decagon.OakLandv1be.repositries.PersonRepository;
import com.decagon.OakLandv1be.repositries.ProductRepository;
import com.decagon.OakLandv1be.repositries.SubCategoryRepository;
import com.decagon.OakLandv1be.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ProductRepository productRepository;
    private final PersonRepository personRepository;

    @Override
    public ProductResponseDto fetchASingleProduct(Long product_id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken))
            throw new ResourceNotFoundException("You need to login carry ut this operation");
            String email = authentication.getName();
            personRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException("Admin User not found"));
            Product product = productRepository.findById(product_id)
                    .orElseThrow(() -> new ProductNotFoundException("This product was not found"));
            return ProductResponseDto.builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .imageUrl(product.getImageUrl())
                    .availableQty(product.getAvailableQty())
                    .subCategory(product.getSubCategory())
                    .color(product.getColor())
                    .description(product.getDescription())
                    .build();
        }
    }
