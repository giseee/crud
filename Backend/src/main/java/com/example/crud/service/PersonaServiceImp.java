package com.example.crud.service;

import com.example.crud.Repository.PersonaRepository;
import com.example.crud.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
 public class PersonaServiceImp implements PersonaService {
        @Autowired
        private PersonaRepository personaRepository;

        @Override
        @Transactional
        public List findAll() throws Exception {
            try {
                List<PersonaEntity> entities= personaRepository.findAll();
                return entities;

            } catch (Exception e) {
                throw new Exception(e.getMessage());

            }
        }

        @Override
        @Transactional
        public PersonaEntity findById(Long id) throws Exception {
            try {
                Optional<PersonaEntity> personaEntity=personaRepository.findById(id);
                return  personaEntity.get();

            } catch (Exception e) {
                throw new Exception(e.getMessage());

            }
        }

        @Override
        @Transactional
        public PersonaEntity save(PersonaEntity entity) throws Exception {
            try {
                entity = personaRepository.save(entity);
                return entity;

            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        @Override
        @Transactional
        public PersonaEntity update(Long id, PersonaEntity entity) throws Exception {
            try {
                Optional<PersonaEntity> optionalPersonaEntity= personaRepository.findById(id);
                PersonaEntity persona= optionalPersonaEntity.get();
                persona= personaRepository.save(persona);
                return persona;


            } catch (Exception e) {
                throw new Exception(e.getMessage());

            }
        }

        @Override
        @Transactional
        public boolean delete(Long id) throws Exception {
            try {
                if (personaRepository.existsById(id)) {
                    personaRepository.deleteById(id);
                    return true;
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());

            }

            return false;
        }
}