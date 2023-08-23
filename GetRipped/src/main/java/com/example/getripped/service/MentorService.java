package com.example.getripped.service;

import com.example.getripped.dtos.MentorDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.models.Exercise;
import com.example.getripped.models.Mentors;
import com.example.getripped.repository.MentorRepo;
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

    public Exercise createExercise(Exercise exercise, HttpSession session) {
        Mentors mentorDto = (Mentors) session.getAttribute("auth");
        exercise.setMentorId(mentorDto.getId());
        exercise.setCategory(mentorDto.getSpecialization());
        return exerciseRepo.save(exercise);
    }
    public DietPlan createDiet (DietPlan dietPlan, HttpSession session){
        Mentors mentorDto = (Mentors) session.getAttribute("auth");
        dietPlan.setMentorId(mentorDto.getId());
        exercise.setCategory(mentorDto.getSpecialization());
        return dietPlan.save(dietPlan);
    }

    public Exercise editExercise (Exercise exercise, HttpSession session) {
        Mentors mentorDto = (Mentors) session.getAttribute("auth");
        exercise.setMentorId(mentorDto.getId());
        exercise.setCategory(mentorDto.getSpecialization());
        return exerciseRepo.update(exercise);
    }

    public Exercise deleteExercise(Exercise exercise, HttpSession session) {
        Mentors mentorDto = (Mentors) session.getAttribute("auth");
        exercise.setMentorId(mentorDto.getId());
        exercise.setCategory(mentorDto.getSpecialization());
        return exerciseRepo.update(exercise);
    }

    public Exercise editDiet (Exercise exercise, HttpSession session) {
        Mentors mentorDto = (Mentors) session.getAttribute("auth");
        exercise.setMentorId(mentorDto.getId());
        exercise.setCategory(mentorDto.getSpecialization());
        return exerciseRepo.update(exercise);
    }

    public Exercise deleteDiet (Exercise exercise, HttpSession session) {
        Mentors mentorDto = (Mentors) session.getAttribute("auth");
        exercise.setMentorId(mentorDto.getId());
        exercise.setCategory(mentorDto.getSpecialization());
        return exerciseRepo.update(exercise);
    }

    public MentorDto getMentorsById (Long Id ){
        Optional<Mentors> updateId= mentorRepo.findById(Id);
        if(updateId.isEmpty()){
            throw new RuntimeException();
        }return new MentorDto(updateId.get());
    }


}
