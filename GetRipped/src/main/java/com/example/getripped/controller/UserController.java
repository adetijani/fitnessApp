package com.example.getripped.controller;

import com.example.getripped.dtos.LoginDto;
import com.example.getripped.dtos.UserDto;
import com.example.getripped.models.Users;
import com.example.getripped.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
     @PostMapping("/signup")
    public ResponseEntity<UserDto> createAccount(@RequestBody UserDto userDto){
         UserDto createdUser = userService.signUp(userDto);
         return  ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
     }
     @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
         UserDto loggedInUser = userService.login(loginDto.getEmail(), loginDto.getPassword(), session);
         if(loggedInUser != null){
             return ResponseEntity.ok().body("Welcome");
         } else {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
         }
     }
     @PutMapping("/update/{userId}")
     public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto updateUserDto){
         UserDto updateUser = userService.updateUser(userId, updateUserDto);
         return ResponseEntity.ok().body(updateUser);
     }

     @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
         userService.deleteUser(userId);
         return ResponseEntity.ok().body("Successfully deleted user");
     }
}
