package jcastaneda.bediscussion2.service;

import jcastaneda.bediscussion2.dto.UserDTO;
import jcastaneda.bediscussion2.entity.UsersEntity;
import jcastaneda.bediscussion2.model.UserRequest;
import jcastaneda.bediscussion2.repository.UsersRepository;
import jcastaneda.bediscussion2.util.DateTimeUtil;
import org.modelmapper.ModelMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final DateTimeUtil dateTimeUtil;
    private final ModelMapper modelMapper;

    public UserDTO registerUser(@NonNull UserRequest userRequest) {

        // Check if email already exist
        if(usersRepository.findByEmail(userRequest.getEmail()) != null ) throw new RuntimeException("Email already in use");

        // Initialize new user data
        UsersEntity userEntity = UsersEntity.builder()
                .userId(UUID.randomUUID())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .password(userRequest.getPassword())
                .email(userRequest.getEmail())
                .mobileNumber(userRequest.getMobileNumber())
                .totalOrders(0)
                .successOrders(0)
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build();


        // save to database
        usersRepository.save(userEntity);


        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        List<UsersEntity> oldList = usersRepository.findAll();
        List<UserDTO> newList = new ArrayList<>();

        oldList.forEach(user -> {
            newList.add(modelMapper.map(user, UserDTO.class));
        });

        return newList;
    }
}
