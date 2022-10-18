package com.br.todolist.services;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.br.todolist.dtos.PeopleDTO;
import com.br.todolist.interfaces.PeopleServiceInterface;
import com.br.todolist.models.PeopleModel;
import com.br.todolist.repositories.PeopleRepository;

public class PeopleService implements PeopleServiceInterface{
    @Autowired
    private PeopleRepository repository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public List<PeopleModel> findAll() {
        return repository.findAll();
    }

    @Override
    public PeopleModel findById(UUID id) {
        return null;
    }

    @Override
    public PeopleModel create(PeopleDTO peopleDTO) {
        return repository.save(mapper.map(peopleDTO, PeopleModel.class));
    }

    @Override
    public PeopleModel update(PeopleDTO peopleDTO) {
        return repository.save(mapper.map(peopleDTO, PeopleModel.class));
    }

    @Override
    public void deleteById(UUID id) {
        findById(id);
        repository.deleteById(id);
        
    }
}
