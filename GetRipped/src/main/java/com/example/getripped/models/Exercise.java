package com.example.getripped.models;

import com.example.getripped.dtos.ExerciseDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Exercise extends PlanBaseEntity{
    private String exerciseName;
    private Long mentorId;

    public Exercise (ExerciseDto exerciseDto){
        this.exerciseName = exerciseDto.getExerciseName();
        this.mentorId = exerciseDto.getMentorId();
        setCategory(exerciseDto.getCategory());
        setWeightGainRange(exerciseDto.getWeightGainRange());
        setCurrentWeightRange(exerciseDto.getCurrentWeightRange());
        setWeightLossRange(exerciseDto.getWeightLossRange());
    }
}
