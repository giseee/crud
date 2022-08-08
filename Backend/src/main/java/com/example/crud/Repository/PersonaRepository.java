package com.example.crud.Repository;

import com.example.crud.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


 public interface  PersonaRepository extends JpaRepository<PersonaEntity,Long> {
    }
