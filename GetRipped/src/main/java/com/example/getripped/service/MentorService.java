package com.example.getripped.service;

import com.example.getripped.dtos.DietDto;
import com.example.getripped.dtos.MentorDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.models.Exercise;
import com.example.getripped.models.Mentors;
import com.example.getripped.repository.MentorRepo;
import com.example.getripped.repository.DietRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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


    public Mentors getMentorById(Long mentorId) {
        return mentorRepo.findMentorById(mentorId);
    }

    public ExercisePlan createExercise (ExerciseDto exerciseDto){
        DietPlan dietPlan = new DietPlan(exerciseDto);
        return exerciseRepo.save(exercisePlan);
    }
    public DietPlan createDiet (DietDto dietDto){
        DietPlan dietPlan = new DietPlan(dietDto);
        return dietRepo.save(dietPlan);
    }

    public DietPlan editExercise (ExercisePlan exercisePlan) {
        ExercisePlan diet = dietRepo.findById(exercisePlan.getId()).orElseThrow();
        exercise.setExerciseName(exercisePlan.getExercise());
        exercise.setCategory(exercisePlan.getCategory());
        exercise.setMentorId(exercisePlan.getMentorId());
        exercise.setWeightGainRange(exercisePlan.getWeightGainRange());
        return exerciseRepo.save(exercise);
    }

    public void deleteExercise (Long Id) {
        exerciseRepo.deleteById\(Id);
    }

    public DietPlan editDiet (DietPlan dietPlan) {
        DietPlan diet = dietRepo.findById(dietPlan.getId()).orElseThrow();
        diet.setDiet(dietPlan.getDiet());
        diet.setCategory(dietPlan.getCategory());
        diet.setMentorId(dietPlan.getMentorId());
        diet.setWeightGainRange(dietPlan.getWeightGainRange());
        return dietRepo.save(diet);
    }

    public void deleteDiet (Long Id) {
        dietRepo.deleteById(Id);
    }

    public MentorDto getMentorsById (Long Id ){
        Optional<Mentors> updateId= mentorRepo.findById(Id);
        if(updateId.isEmpty()){
            throw new RuntimeException();
        }return new MentorDto(updateId.get());
    }


}
