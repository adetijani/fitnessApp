package com.example.getripped.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exercise extends PlanBaseEntity{
    private String exerciseName;
    private Long mentorId;
}
