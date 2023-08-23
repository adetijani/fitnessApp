package com.example.getripped.models;

import com.example.getripped.dtos.DietDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class DietPlan extends PlanBaseEntity{
    private String diet;
    private Long mentorId;


    public DietPlan(DietDto dietDto){
        this.diet = dietDto.getDiet();
        this.mentorId = dietDto.getMentorId();
    }
}
