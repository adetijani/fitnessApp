package com.example.getripped.controller;

import com.example.getripped.dtos.DietDto;
import com.example.getripped.models.DietPlan;
import com.example.getripped.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DietController {

    private DietService dietService;

    @PostMapping("create-diet")
    public ResponseEntity<DietDto> createDietPlan(@RequestBody DietDto dietDto){
        return dietService.createDietPlan(dietDto);
    }


    @GetMapping("get-diet/{dietId}")
    public ResponseEntity<DietDto> getDietPlanById(@PathVariable Long dietId){
        return dietService.findDietPlanById(dietId);
    }

    @PutMapping("update-diet/{dietId}")
    public ResponseEntity<String> updateDietPlan(@PathVariable Long dietId, @RequestBody DietDto dietDto){
       return dietService.updateDietPlan(dietId,dietDto);
    }


    @DeleteMapping("delete-plan/{dietId}")
    public ResponseEntity<String> deleteDietPLan(@PathVariable Long dietId){
    return dietService.deleteDietPlan(dietId);
    }
}
