package com.decagon.OakLandv1be.services.serviceImpl;

import com.decagon.OakLandv1be.dto.StateRequest;
import com.decagon.OakLandv1be.dto.StateResponse;
import com.decagon.OakLandv1be.entities.Person;
import com.decagon.OakLandv1be.entities.State;
import com.decagon.OakLandv1be.enums.Role;
import com.decagon.OakLandv1be.exceptions.AlreadyExistsException;
import com.decagon.OakLandv1be.exceptions.AuthorizationException;
import com.decagon.OakLandv1be.exceptions.ResourceNotFoundException;
import com.decagon.OakLandv1be.exceptions.UserNotFoundException;
import com.decagon.OakLandv1be.repositries.PersonRepository;
import com.decagon.OakLandv1be.repositries.PickupRepository;
import com.decagon.OakLandv1be.repositries.StateRepository;
import com.decagon.OakLandv1be.services.StatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class StatesServiceImpl implements StatesService {
    private final PersonRepository personRepository;
    private final StateRepository stateRepository;

    private final PickupRepository pickupRepository;
    @Transactional
    @Override
    public String createState(StateRequest stateRequest) {
        if(!confirmAuthority()) throw new AuthorizationException("You are NOT AUTHORIZED to perform this operation");
        if(stateRepository.existsByName(stateRequest.getNameOfState().toUpperCase())) {throw new AlreadyExistsException("State already exists");}

        stateRepository.save(State.builder()
                .name(stateRequest.getNameOfState().toUpperCase()).build()
//                .setPickupCenters(pickupRepository.findByName(stateRequest.get.orElseThrow(
//                        ()-> new ResourceNotFoundException("No state with the name {}",pickupCenterRequest.getStateName().toUpperCase())
//                )));
        );
        return "State created successfully";

    }

    @Override
    public void deleteState(Long id) {
        if(!confirmAuthority()) throw new AuthorizationException("You are NOT AUTHORIZED to perform this operation");
        if(stateRepository.existsById(id)) {stateRepository.deleteById(id);}
        else throw new ResourceNotFoundException("No State with such name exists");
    }

    @Override
    public StateResponse viewStateByName(String name) {
        State state = stateRepository.findByName(name.toUpperCase()).orElseThrow(
                () -> new ResourceNotFoundException("State not found"));
        return responseMapper(state);
    }
    private boolean confirmAuthority(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserEmail = authentication.getName();
        Person loggedInUser = personRepository.findByEmail(loggedInUserEmail).orElseThrow(() -> new UserNotFoundException("No user with this email"));
        return loggedInUser.getRole()== Role.ADMIN;
    }

    protected StateResponse responseMapper(State stateResponse) {
        return StateResponse.builder()
                .id(stateResponse.getId())
                .name(stateResponse.getName())
                .pickupCenters(stateResponse.getPickupCenters())
                .build();
    }

}
