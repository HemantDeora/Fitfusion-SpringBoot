package com.training.Service;

import com.training.Dto.UserRequestDto;
import com.training.Dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto register(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();
}
