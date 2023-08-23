package com.example.getripped.repository;

import com.example.getripped.models.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepo extends JpaRepository<DietPlan, Long> {


}
