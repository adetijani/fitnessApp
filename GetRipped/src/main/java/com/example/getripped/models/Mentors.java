package com.example.getripped.models;

import com.example.getripped.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.HTMLDocument;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mentors extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private Category specialization;
    private int accountStatus;
}
