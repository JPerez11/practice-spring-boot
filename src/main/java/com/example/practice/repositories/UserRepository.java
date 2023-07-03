package com.example.practice.repositories;

import com.example.practice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByDocumentNumber(String documentNumber);
    boolean existsByEmail(String email);

}
