package com.decagon.OakLandv1be.dto;

import com.decagon.OakLandv1be.entities.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewProductRequestDto {
    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @DecimalMin(value="0.0", message="Field Price cannot be blank")
    private Double price;

    @NotBlank(message = "Field ImageUrl cannot be blank")
    private String imageUrl;

    @Range(min=0, message = "Field Available Quantity cannot be blank")
    private Integer availableQty;

    @NotNull(message="Field SubCategory cannot be null")
    private String subCategory;

    @NotNull(message = "Field Category cannot be null")
    private String category;

    @NotBlank(message = "Field Color cannot be blank")
    private String color;

    @NotBlank(message = "Field Description cannot be blank")
    private String description;

}
