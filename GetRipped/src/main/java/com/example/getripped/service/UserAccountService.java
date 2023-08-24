package com.example.getripped.service;

import com.example.getripped.dtos.UserAccountDto;
import com.example.getripped.dtos.UserDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.models.UserAccount;
import com.example.getripped.models.Users;
import com.example.getripped.repository.UserAccountRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {
    private final UserAccountRepo userAccountRepo;
    private final HttpSession session;

    public ResponseEntity<UserAccountDto> createUserAccount (UserAccountDto userAccountDto) {
        Users user = (Users) session.getAttribute("Auth");
        userAccountDto.setUserId(user.getId());
        UserAccount userAccount = userAccountRepo.save(new UserAccount(userAccountDto));
         return new ResponseEntity<>(new UserAccountDto(userAccount), HttpStatus.CREATED);
    }
    public ResponseEntity<UserAccountDto> updateUserAccount (UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountRepo.save(new UserAccount(userAccountDto));
        return new ResponseEntity<>(new UserAccountDto(userAccount),HttpStatus.OK);
    }
    public ResponseEntity<UserAccountDto> deleteUserAccount (UserAccountDto userAccountDto) {
        userAccountRepo.deleteById(userAccountDto.getId());
        return new ResponseEntity<>(userAccountDto,HttpStatus.OK);
    }

    public ResponseEntity<UserAccountDto> getUserAccountDto(Long Id) {
        UserAccount userAccount = userAccountRepo.findByUserId(Id);
        return new ResponseEntity<>(new UserAccountDto(userAccount),HttpStatus.OK);
    }
}


