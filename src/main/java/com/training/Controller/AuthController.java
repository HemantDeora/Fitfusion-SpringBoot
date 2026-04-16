package com.training.Controller;

import com.training.Dto.UserRequestDto;
import com.training.Dto.UserResponseDto;
import com.training.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(
            @Valid @RequestBody UserRequestDto userRequestDto) {

        UserResponseDto response = userService.register(userRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}
