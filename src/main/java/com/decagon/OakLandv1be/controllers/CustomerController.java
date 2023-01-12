package com.decagon.OakLandv1be.controllers;

import com.decagon.OakLandv1be.dto.*;
import com.decagon.OakLandv1be.entities.Customer;
import com.decagon.OakLandv1be.exceptions.AlreadyExistsException;
import com.decagon.OakLandv1be.services.CustomerService;
import com.decagon.OakLandv1be.utils.ApiResponse;
import com.decagon.OakLandv1be.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/signup")

    public ResponseEntity<SignupResponseDto> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) throws AlreadyExistsException, IOException {
        SignupResponseDto signupResponseDto = customerService.saveCustomer(signupRequestDto);
        return new ResponseEntity<>(signupResponseDto, HttpStatus.CREATED);
    }
    @PostMapping("/verifyRegistration/{token}")
    public ResponseEntity<ApiResponse> verifyAccount(@PathVariable String token){
        return customerService.verifyRegistration(token);
    }

    @PutMapping("/edit-profile")
    public ResponseEntity<String> editProfile(@Valid @RequestBody EditProfileRequestDto editProfileRequestDto){
        customerService.editProfile(editProfileRequestDto);
        return new ResponseEntity<>("Profile Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/product/favorites/remove/{pid}")
    public ResponseEntity<String> addFavorites(@PathVariable Long pid){
        customerService.removeProductFromFavorites(pid);
        return new ResponseEntity<>("Product added to favourites successfully", HttpStatus.ACCEPTED);
    }
    }



