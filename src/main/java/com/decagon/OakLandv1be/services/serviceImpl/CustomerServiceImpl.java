package com.decagon.OakLandv1be.services.serviceImpl;

import com.decagon.OakLandv1be.dto.SignupRequestDto;
import com.decagon.OakLandv1be.dto.SignupResponseDto;
import com.decagon.OakLandv1be.entities.*;
import com.decagon.OakLandv1be.enums.Role;
import com.decagon.OakLandv1be.exceptions.AlreadyExistsException;
import com.decagon.OakLandv1be.repositries.CustomerRepository;
import com.decagon.OakLandv1be.services.CustomerService;
import com.decagon.OakLandv1be.utils.ApiResponse;
import com.decagon.OakLandv1be.utils.ResponseManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Data
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ResponseManager responseManager;

    @Override
    public ApiResponse<SignupResponseDto> saveCustomer(SignupRequestDto signupRequestDto) throws AlreadyExistsException {
        // Checking database if email already exist
        boolean emailExist = customerRepository.existsByEmail(signupRequestDto.getEmail());
        if(emailExist)
            throw new AlreadyExistsException("This Email address already exists");

        Customer customer = new Customer();

        Address address = Address.builder()
                .fullName(signupRequestDto.getFirstName() + " "+ signupRequestDto.getLastName())
                .emailAddress(signupRequestDto.getEmail())
                .state(signupRequestDto.getState())
                .country(signupRequestDto.getCountry())
                .street(signupRequestDto.getStreet())
                .build();

        Person person = Person.builder()
                .role(Role.CUSTOMER)
                .verificationStatus(false)
                .address(address)
                .customer(customer)
                .build();
        customer.setPerson(person);

        Cart cart = Cart.builder()
                .customer(customer)
                .total(0.00)
                .items(new HashSet<>())
                .build();
        customer.setCart(cart);

        customerRepository.save(customer);

        // use the user object to create UserResponseDto Object
        SignupResponseDto signupResponseDto = new SignupResponseDto();
        BeanUtils.copyProperties(customer, signupResponseDto);

        return responseManager.success(signupResponseDto);
    }
}
