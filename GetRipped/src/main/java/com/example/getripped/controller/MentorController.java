package com.example.getripped.controller;

import com.example.getripped.models.DietPlan;
import com.example.getripped.models.Exercise;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mentor")
@RequiredArgsConstructor
public class MentorController {
    @Autowired
    private ExerciseRepo exerciseRepo;

    @Autowired
    private DietRepo dietRepo;




    @PostMapping("save/exercise")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        Exercise createdExercise = exerciseRepo.save(exercise);
        return new ResponseEntity(createdExercise,HttpStatus.CREATED);
    }

    @PostMapping("save/diet")
    public ResponseEntity<DietPlan> createDiet (@RequestBody DietPlan dietPlan){
        DietPlan createdDiet = dietRepo.save(dietPlan);
        return new ResponseEntity(createdDiet,HttpStatus.CREATED);
    }

    @PutMapping("edit/exercise")
    public ResponseEntity<Exercise> editExercise (@RequestBody Exercise exercise){
        Exercise editExercise = exerciseRepo.update(exercise);
        return new ResponseEntity(editExercise,HttpStatus.CREATED);
    }

    @PutMapping("edit/diet")
    public ResponseEntity<DietPlan> editDiet (@RequestBody DietPlan dietPlan){
        DietPlan editDiet = dietRepo.update(dietPlan);
        return new ResponseEntity(editDiet,HttpStatus.CREATED);
    }

    @DeleteMapping("delete/exercise")
    public ResponseEntity<Exercise> deleteExercise (@RequestBody Exercise exercise){
        Exercise deleteExercise = exerciseRepo.update(exercise);
        return new ResponseEntity(deleteExercise,HttpStatus.CREATED);
    }

    @DeleteMapping("delete/diet")
    public ResponseEntity<DietPlan> deleteDiet (@RequestBody DietPlan dietPlan){
        DietPlan deleteDiet = dietRepo.update(DietPlan);
        return new ResponseEntity(deleteDiet,HttpStatus.CREATED);
    }

}
