package com.example.getripped.service;

import com.example.getripped.dtos.UserDto;
import com.example.getripped.models.Users;
import com.example.getripped.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public UserDto signUp(UserDto userdto) {
        String password = BCrypt.hashpw(userdto.getPassword(), BCrypt.gensalt());
        Users user = new Users(userdto);
        user.setPassword(password);
        userRepo.save(user);
       return new UserDto(user);
    }
    public UserDto login(String email, String password, HttpSession session){
        Users user = userRepo.findByEmail(email);
        if(user != null && BCrypt.checkpw(password, user.getPassword())){
            session.setAttribute("User", user);
            return  new UserDto(user);
        } else {
            return null;
        }
        }
    }
