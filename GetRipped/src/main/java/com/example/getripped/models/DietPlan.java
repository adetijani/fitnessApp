package com.example.getripped.models;

import com.example.getripped.dtos.DietDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
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
