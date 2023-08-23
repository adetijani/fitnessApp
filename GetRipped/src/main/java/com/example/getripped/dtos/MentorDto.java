package com.example.getripped.dtos;

import com.example.getripped.enums.Category;
import com.example.getripped.models.Mentors;

import java.security.PrivateKey;

public class MentorDto {
    private String mentorName;
    private String email;
    private Category specialization;

    public MentorDto (Mentors mentors){
        this.specialization = mentors.getSpecialization();
    }
}
