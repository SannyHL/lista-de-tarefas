package com.br.todolist.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.todolist.dtos.PeopleDTO;
import com.br.todolist.exceptions.ObjectNotFoundException;
import com.br.todolist.interfaces.PeopleServiceInterface;
import com.br.todolist.models.PeopleModel;
import com.br.todolist.repositories.PeopleRepository;

@Service
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
    public PeopleModel findById(Long id) {
        Optional<PeopleModel> peopleOptional = repository.findById(id);
        return peopleOptional.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
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
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
        
    }
}
