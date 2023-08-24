package com.example.getripped.dtos;

import com.example.getripped.enums.Category;
import com.example.getripped.models.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAccountDto {
    private Long userId;
    private Long dietPlan;
    private Long exercisePlan;
    private Category category;
    private String currentWeightRange;
    private String weightLossRange;
    private String weightGainRange;

    public UserAccountDto(UserAccount userAccount){
      this.dietPlan = userAccount.getDietPlan();
        this.exercisePlan = userAccount.getExercisePlan();
        this.category = userAccount.getCategory();
        this.currentWeightRange = userAccount.getCurrentWeightRange();
        this.weightLossRange = userAccount.getWeightLossRange();
        this.weightGainRange = userAccount.getWeightGainRange();

    }

}






