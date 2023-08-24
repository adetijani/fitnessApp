package com.example.getripped.models;

import com.example.getripped.dtos.UserAccountDto;
import com.example.getripped.enums.Category;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAccount extends PlanBaseEntity{
    private Long userId;
    private Long dietPlan;
    private Long exercisePlan;


    public UserAccount(UserAccountDto userAccountDto){
        this.userId = userAccountDto.getUserId();
        this.dietPlan = userAccountDto.getDietPlan();
        this.exercisePlan = userAccountDto.getExercisePlan();

    }
}
