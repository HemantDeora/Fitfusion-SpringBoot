package com.training.Service.Impl;

import com.training.Dto.UserRequestDto;
import com.training.Dto.UserResponseDto;
import com.training.Entity.User;
import com.training.Repo.UserRepo;
import com.training.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public UserResponseDto register(UserRequestDto userRequestDto) {

        User user = modelMapper.map(userRequestDto, User.class);

        User savedUser = userRepo.save(user);

        return modelMapper.map(savedUser, UserResponseDto.class);
    }
}
