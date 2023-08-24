package com.example.getripped.controller;

import com.example.getripped.dtos.UserAccountDto;
import com.example.getripped.dtos.UserDto;
import com.example.getripped.models.UserAccount;
import com.example.getripped.models.Users;
import com.example.getripped.service.UserAccountService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("account_details")
public class UserAccountController {

    private final UserAccountService userAccountService;


    @PostMapping("save")
    public ResponseEntity<UserAccountDto> save(@RequestBody UserAccountDto userAccountDto, HttpSession session) {
          Users user  = (Users)session.getAttribute("User");
          userAccountService.createUserAccount(userAccountDto, user);

        return null;
    }
    @PostMapping("update")
    public ResponseEntity<UserAccountDto> update (@RequestBody UserAccountDto userAccountDto, HttpSession session) {
        return  null;
    }
    @DeleteMapping("delete")
    public ResponseEntity<UserAccountDto> delete (@RequestBody UserAccountDto userAccountDto,HttpSession session) {
        return null;
    }
    @GetMapping("getUser")
    public ResponseEntity<UserAccountDto> getUser (@PathVariable UserAccountDto userAccountDto,HttpSession session) {
        return null;
    }


}
