package com.example.getripped.repository;

import com.example.getripped.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {

}
