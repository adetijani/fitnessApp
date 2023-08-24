package com.example.getripped.models;
import com.example.getripped.dtos.DietDto;
import com.example.getripped.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class PlanBaseEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Category category;
    private String currentWeightRange;
    private String weightLossRange;
    private String weightGainRange;
}

