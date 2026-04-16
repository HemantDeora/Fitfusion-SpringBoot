package com.training.Service;

import com.training.Dto.UserRequestDto;
import com.training.Dto.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRequestDto userRequestDto);
}
