package com.example.getripped.service;

import com.example.getripped.dtos.ExerciseDto;
import com.example.getripped.models.Exercise;
import com.example.getripped.repository.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseService {
    public final ExerciseRepo exerciseRepo;

    @Autowired
    public ExerciseService(ExerciseRepo exerciseRepo){
        this.exerciseRepo = exerciseRepo;
    }

    public ResponseEntity<ExerciseDto> createExercise (ExerciseDto exerciseDto){
        Exercise exercise = new Exercise(exerciseDto);
        Exercise savedExercise = exerciseRepo.save(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ExerciseDto(savedExercise));
    }
    public ResponseEntity<ExerciseDto> getExerciseById(Long id){
       Optional<Exercise> optionalExercise = exerciseRepo.findById(id);
       if(optionalExercise.isPresent()){
           ExerciseDto exerciseDto = new ExerciseDto(optionalExercise.get());
           return ResponseEntity.ok(exerciseDto);
       }else {
           return ResponseEntity.notFound().build();
       }
    }
    public ResponseEntity<Void> updateExercise (Long id, ExerciseDto exerciseDto){
        Optional<Exercise> optionalExercise = exerciseRepo.findById(id);
        if(optionalExercise.isPresent()){
            Exercise exercise = optionalExercise.get();
            exercise.setExerciseName(exerciseDto.getExerciseName());
            exercise.setMentorId(exerciseDto.getMentorId());
            exercise.setWeightGainRange(exerciseDto.getWeightGainRange());
            exercise.setWeightLossRange(exerciseDto.getWeightLossRange());
            exercise.setCurrentWeightRange(exerciseDto.getCurrentWeightRange());
            exercise.setCategory(exerciseDto.getCategory());

            exerciseRepo.save(exercise);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Void> deleteExercise (Long id){
        if(exerciseRepo.existsById(id)){
            exerciseRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
