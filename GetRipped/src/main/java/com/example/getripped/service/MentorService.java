package com.example.getripped.service;

import com.example.getripped.dtos.DietDto;
import com.example.getripped.dtos.ExerciseDto;
import com.example.getripped.dtos.MentorDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.models.Exercise;
import com.example.getripped.models.Mentors;
import com.example.getripped.repository.ExerciseRepo;
import com.example.getripped.repository.MentorRepo;
import com.example.getripped.repository.DietRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MentorService {
    private MentorRepo mentorRepo;
    private Mentors mentors;
    private Exercise exercise;
    private ExerciseRepo exerciseRepo;
    private DietRepo dietRepo;
    private MentorService mentorService;

    private DietService dietService;
    private ExerciseService exerciseService;



    public MentorDto getMentorById (Long Id ){
        Optional<Mentors> updateId= mentorRepo.findMentorById(Id);
        if(updateId.isEmpty()){
            throw new RuntimeException();
        }return new MentorDto(updateId.get());
    }



    public Exercise createExercise (ExerciseDto exerciseDto){
        Exercise exercise = new Exercise (exerciseDto);
        return exerciseRepo.save(exercise);
    }
    public DietPlan createDiet (DietDto dietDto){
        DietPlan dietPlan = new DietPlan(dietDto);
        return dietRepo.save(dietPlan);
    }



    public ResponseEntity<String> updateExercise (Long Id,ExerciseDto exerciseDto) {
        exerciseService.updateExercise(Id, exerciseDto);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
    public ResponseEntity<String> updateDietPlan (Long dietId, DietDto dietDto) {
        dietService.updateDietPlan(dietId, dietDto);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }



    public void deleteExercise (Long Id) {
        exerciseRepo.deleteById(Id);
    }

    public void deleteDiet (Long Id) {
        dietRepo.deleteById(Id);
    }

}
