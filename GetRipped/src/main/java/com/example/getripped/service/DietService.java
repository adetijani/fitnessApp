package com.example.getripped.service;


import com.example.getripped.dtos.DietDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.repository.DietRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DietService {

    private final DietRepo dietRepo;


    public ResponseEntity<DietDto> createDietPlan(DietDto dietDto) {
        DietPlan dietPlan = dietRepo.save(new DietPlan(dietDto));
        DietDto dietDto1 = new DietDto(dietPlan);
        return new ResponseEntity<>(dietDto1, HttpStatus.CREATED);
    }

    public ResponseEntity<DietDto> findDietPlanById(Long id) {
        DietPlan dietPlan = dietRepo.findById(id).orElseThrow();
        DietDto dietDto1 = new DietDto(dietPlan);
        return new ResponseEntity<>(dietDto1, HttpStatus.FOUND);

    }

    public ResponseEntity<String> updateDietPlan(Long dietId, DietDto dietDto) {
        DietPlan dietPlan = dietRepo.findById(dietId).orElseThrow();
        dietPlan.setDiet(dietDto.getDiet());
        dietPlan.setCategory(dietDto.getCategory());
        dietPlan.setCurrentWeightRange(dietDto.getCurrentWeightRange());
        dietPlan.setWeightLossRange(dietDto.getWeightLossRange());
        dietPlan.setWeightGainRange(dietDto.getWeightGainRange());
        dietRepo.save(dietPlan);
        String msg = "UPDATED SUCCESSFULLY";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDietPlan(Long dietId) {
        dietRepo.deleteById(dietId);
        String msg = "DELETION SUCCESSFUL";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


}
