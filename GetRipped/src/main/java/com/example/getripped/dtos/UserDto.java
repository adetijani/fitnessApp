package com.example.getripped.dtos;

import com.example.getripped.enums.Gender;
import com.example.getripped.enums.Role;
import com.example.getripped.models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor

public class UserDto {
    private String name;
    private String email;
    private String password;
    private Date birthdate;
    private Integer regStatus;
    private Role role;
    private Gender gender;

    public UserDto(Users users){
        this.name = users.getName();
        this.email = users.getEmail();
        this.password = users.getPassword();
        this.birthdate = users.getBirthdate();
        this.regStatus = users.getRegStatus();
        this.role = users.getRole();
        this.gender = users.getGender();
    }
}
