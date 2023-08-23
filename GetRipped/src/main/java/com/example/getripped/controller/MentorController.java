package com.example.getripped.controller;

import com.example.getripped.dtos.DietDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.models.Exercise;
import com.example.getripped.service.DietService;
import com.example.getripped.service.MentorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import com.example.getripped.repository.DietRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mentor")
@RequiredArgsConstructor
public class MentorController {

    private final ExerciseService exerciseService;
    private final DietService dietService;
    private final MentorService mentorService;




    @PostMapping("save/exercise")
    public ResponseEntity<ExerciseDto> createExercise (@RequestBody ExerciseDto exerciseDto){
        return dietService.createDietPlan(exerciseDto);
    }

    @PostMapping("save/diet")
    public ResponseEntity<DietDto> createDiet (@RequestBody DietDto dietDto){
        return dietService.createDietPlan(dietDto);
    }

    @PutMapping("edit/exercise")
    public ResponseEntity<DietPlan> editExercise (@RequestBody ExercisePlan exercisePlan){
        DietPlan editExercise = mentorService.editExercise(exercisePlan);
        return new ResponseEntity(editExercise,HttpStatus.CREATED);
    }
    @PutMapping("edit/diet")
    public ResponseEntity<DietPlan> editDiet (@RequestBody DietPlan dietPlan){
        DietPlan editDiet = mentorService.editDiet(dietPlan);
        return new ResponseEntity(editDiet,HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{exerciseId}")
    public ResponseEntity<String> deleteExercise (@PathVariable Long exerciseId){
        mentorService.deleteExercise(exerciseId);
        return new ResponseEntity("deleted successfully",HttpStatus.OK);
    }

    @DeleteMapping("delete/{dietId}")
    public ResponseEntity<String> deleteDiet (@PathVariable Long dietId){
         mentorService.deleteDiet(dietId);
        return new ResponseEntity("deleted successfully",HttpStatus.OK);
    }

}
