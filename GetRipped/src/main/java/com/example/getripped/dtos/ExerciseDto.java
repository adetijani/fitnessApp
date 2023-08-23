package com.example.getripped.dtos;

import com.example.getripped.enums.Category;
import com.example.getripped.models.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExerciseDto {
    private String exerciseName;
    private Category category;
    private String currentWeightRange;
    private String weightLossRange;
    private String weightGainRange;
    private Long mentorId;

    public ExerciseDto(Exercise exercise){
        this.exerciseName = exercise.getExerciseName();
        this.mentorId = exercise.getMentorId();
        this.weightGainRange = exercise.getWeightGainRange();
        this.weightLossRange = exercise.getWeightLossRange();
        this.currentWeightRange = exercise.getCurrentWeightRange();
        this.category = exercise.getCategory();
    }

}
