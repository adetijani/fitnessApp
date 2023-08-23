package com.example.getripped.repository;

import com.example.getripped.models.Mentors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepo extends JpaRepository<Mentors, Long> {

    Optional<Mentors> findMentorById(Long Id);
}
