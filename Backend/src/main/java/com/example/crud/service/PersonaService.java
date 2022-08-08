package com.example.crud.service;


import com.example.crud.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {
    public List<PersonaEntity> findAll() throws Exception;
    public PersonaEntity findById(Long id) throws Exception;
    public PersonaEntity save(PersonaEntity entity) throws Exception;
    public PersonaEntity update(Long id, PersonaEntity entity) throws  Exception;
    public boolean delete(Long id) throws Exception;
}
