package com.example.getripped.repository;

import com.example.getripped.models.UserAccount;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
    UserAccount findByUserId(Long id);
    // Optional<UserAccount> findByUserId(Long userId);

}
