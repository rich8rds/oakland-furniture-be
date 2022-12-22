package com.decagon.OakLandv1be.services;

import com.decagon.OakLandv1be.dto.NewProductRequestDto;
import com.decagon.OakLandv1be.dto.OperationStatus;
import com.decagon.OakLandv1be.dto.ProductResponseDto;
import com.decagon.OakLandv1be.entities.Product;
import com.decagon.OakLandv1be.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

public interface AdminService {
    ProductResponseDto fetchASingleProduct(Long product_id);

    ResponseEntity<Product> addNewProduct(@Valid NewProductRequestDto productDto);

   ApiResponse<OperationStatus> deleteProduct(Long product_id);

}
