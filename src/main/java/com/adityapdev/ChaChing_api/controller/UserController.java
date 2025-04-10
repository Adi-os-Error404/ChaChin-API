package com.adityapdev.ChaChing_api.controller;


import com.adityapdev.ChaChing_api.dto.user.LoginUserDto;
import com.adityapdev.ChaChing_api.dto.user.RegisterNewUserDto;
import com.adityapdev.ChaChing_api.dto.user.UpdateUserPassDto;
import com.adityapdev.ChaChing_api.dto.user.UserDetailDto;
import com.adityapdev.ChaChing_api.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDetailDto> registerUser(@RequestBody RegisterNewUserDto registerNewUserDto) {
        UserDetailDto savedUser = userService.registerNewUser(registerNewUserDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDetailDto> loginUser(@RequestBody LoginUserDto loginUserDto) {
        UserDetailDto userDto = userService.verifyUserCredentials(loginUserDto.getEmail(), loginUserDto.getPassword());
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDetailDto>> getAllUsers() {
        List<UserDetailDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{email}")
    public ResponseEntity<UserDetailDto> getUserByEmail(@PathVariable("email") String email) {
        UserDetailDto userDto = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("{id}/name")
    public ResponseEntity<UserDetailDto> updateUserFirstLastName(@PathVariable("id") Long id, @RequestBody UserDetailDto userDetailDto) {
        UserDetailDto userDto = userService.updateUserName(id, userDetailDto);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("{id}/permission")
    public ResponseEntity<UserDetailDto> updateUserPermission(@PathVariable("id") Long id, @RequestBody UserDetailDto userDetailDto) {
        UserDetailDto userDto = userService.updateUserPermission(id, userDetailDto);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("{id}/password")
    public ResponseEntity<UserDetailDto> updateUserPassword(@PathVariable("id") Long id, @RequestBody UpdateUserPassDto updatedUserDto) {
        UserDetailDto userDto = userService.updateUserPassword(id, updatedUserDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(String.format("User with id %d is deleted successfully.", id));
    }

}
