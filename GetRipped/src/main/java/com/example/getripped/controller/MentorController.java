package com.example.getripped.controller;

import com.example.getripped.dtos.DietDto;
import com.example.getripped.dtos.ExerciseDto;
import com.example.getripped.dtos.MentorDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.models.Exercise;
import com.example.getripped.service.DietService;
import com.example.getripped.service.ExerciseService;
import com.example.getripped.service.MentorService;
import lombok.RequiredArgsConstructor;
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



    @GetMapping("/{id}")
    public ResponseEntity<MentorDto> getMentorById(@PathVariable Long id) {
        MentorDto mentorDto = mentorService.getMentorById(id);
        return ResponseEntity.ok(mentorDto);
    }

    @PostMapping("save/exercise")
    public ResponseEntity<ExerciseDto> createExercise (@RequestBody ExerciseDto exerciseDto){
        Exercise exercise = mentorService.createExercise(exerciseDto);
        return ResponseEntity.ok(exerciseDto);
    }

    @PostMapping("save/diet")
    public DietPlan createDiet (@RequestBody DietDto dietDto){
        DietPlan dietPlan = mentorService.createDiet(dietDto);
        return mentorService.createDiet(dietDto);
    }

    @PutMapping("edit/{Id}")
    public ResponseEntity<ExerciseDto> updateExercise (@RequestBody Long id, ExerciseDto exerciseDto){
        ResponseEntity<String> updateExercise = mentorService.updateExercise(id,exerciseDto);
        return new ResponseEntity(updateExercise,HttpStatus.CREATED);
    }
    @PutMapping("edit/diet")
    public ResponseEntity<DietPlan> updateDietPlan (@RequestBody Long id, DietDto dietDto){
        ResponseEntity<String> updateDietPlan = mentorService.updateDietPlan(id,dietDto);
        return new ResponseEntity(updateDietPlan,HttpStatus.CREATED);
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
