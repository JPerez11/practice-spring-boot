package com.example.practice.repositories;

import com.example.practice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByEmail(String email);
    boolean existsByDocumentNumber(String documentNumber);
    boolean existsByEmail(String email);

}
