package com.example.getripped.dtos;


import com.example.getripped.enums.Category;
import com.example.getripped.models.DietPlan;
import com.example.getripped.models.PlanBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {
    private String diet;
    private Long mentorId;
    private Category category;
    private String currentWeightRange;
    private String weightLossRange;
    private String weightGainRange;


    public DietDto(DietPlan diet){
        this.diet = diet.getDiet();
        this.mentorId = diet.getMentorId();
        this.category = diet.getCategory();
        this.currentWeightRange = diet.getCurrentWeightRange();
        this.weightLossRange =diet.getWeightLossRange();
        this.weightGainRange = diet.getWeightGainRange();
    }

}
