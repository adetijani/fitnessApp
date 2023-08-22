package com.example.getripped.models;
import com.example.getripped.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class PlanBaseEntity extends BaseEntity {
    private Category category;
    private String currentWeightRange;
    private String weightLossRange;
    private String weightGainRange;

}
