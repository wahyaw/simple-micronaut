package com.example.controller;

import com.example.dto.ResponseEntity;
import com.example.dto.UserRequestDto;
import com.example.dto.UserResponseDto;
import com.example.entity.UserEntity;
import com.example.service.UserService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

@Controller(value = "/api/v1/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get(value = "mom")
    public String mom() {
        return "Hello mom!";
    }

    @Get(value = "dad")
    public String dad() {
        UserRequestDto request = new UserRequestDto(
                RandomStringUtils.random(5, true, false),
                RandomStringUtils.random(8, true, true));
        return userService.save(request).getId().toString();
    }

    @Get(value = "users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> responses = new ArrayList<>();
        List<UserEntity> users = userService.getAllUsers();
        users.forEach(user -> responses.add(new UserResponseDto(user.getId(), user.getUsername())));
        return  new ResponseEntity<>(responses);
    }

    @Post("user")
    public ResponseEntity<UserResponseDto> addUser(@Body UserRequestDto requestDto) {
        UserRequestDto request = new UserRequestDto(requestDto.getUsername(), requestDto.getPassword());
        return new ResponseEntity<>(new UserResponseDto(userService.save(request)));
    }


}
