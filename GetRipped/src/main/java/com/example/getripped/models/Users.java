package com.example.getripped.models;

import com.example.getripped.dtos.UserDto;
import com.example.getripped.enums.Gender;
import com.example.getripped.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table(name = "Users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity{
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date birthdate;
    private Integer regStatus;
    private Role role;
    private Gender gender;

    public Users(UserDto userDto){
       this.name = userDto.getName();
       this.lastName = userDto.getLastName();
       this.email = userDto.getEmail();
       this.password = userDto.getEmail();
       this.birthdate = userDto.getBirthdate();
       this.regStatus = userDto.getRegStatus();
       this.role = userDto.getRole();
       this.gender = userDto.getGender();
    }
}
