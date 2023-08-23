package com.example.getripped.controller;

import com.example.getripped.dtos.ExerciseDto;
import com.example.getripped.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    public final ExerciseService exerciseService;
    @Autowired
    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }
    @PostMapping("/create")
    public ResponseEntity<ExerciseDto> createExercise (@RequestBody ExerciseDto exerciseDto){
        return exerciseService.createExercise(exerciseDto);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<ExerciseDto> getExerciseById (@PathVariable Long id){
        return exerciseService.getExerciseById(id);
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Void> updateExercise (@PathVariable Long id, @RequestBody ExerciseDto exerciseDto){
        return exerciseService.updateExercise(id, exerciseDto);
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteExercise (@PathVariable Long id){
        return exerciseService.deleteExercise(id);
    }
}
