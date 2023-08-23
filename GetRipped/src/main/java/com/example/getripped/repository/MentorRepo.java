package com.example.getripped.repository;

import com.example.getripped.models.Mentors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepo extends JpaRepository<Mentors, Long> {

    Mentors findMentorById(Long Id);
}
