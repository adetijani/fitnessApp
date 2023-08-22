package com.example.getripped.service;

import com.example.getripped.dtos.UserDto;
import com.example.getripped.models.Users;
import com.example.getripped.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
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
            session.setAttribute("Auth", user);
            return  new UserDto(user);
        } else {
            return null;
        }
        }

        public UserDto updateUser(Long userId, UserDto updateUserDto){
        Users existingUser = userRepo.findUsersById(userId);
        if(existingUser != null){
            existingUser.setBirthdate(updateUserDto.getBirthdate());
            existingUser.setName(updateUserDto.getName());
            existingUser.setLastName(updateUserDto.getLastName());
            existingUser.setRole(updateUserDto.getRole());
            existingUser.setPassword(updateUserDto.getPassword());
            existingUser.setEmail(updateUserDto.getEmail());
            existingUser.setGender(updateUserDto.getGender());
            existingUser.setRegStatus(updateUserDto.getRegStatus());
            userRepo.save(existingUser);
            return new UserDto(existingUser);
        }else {
            return null;
        }
        }

        public void deleteUser(Long userId){
         userRepo.deleteUsersById(userId);
        }
    }
