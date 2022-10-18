package com.br.todolist.interfaces;

import java.util.List;
import java.util.UUID;

import com.br.todolist.dtos.PeopleDTO;
import com.br.todolist.models.PeopleModel;

public interface PeopleServiceInterface {

    List<PeopleModel> findAll();
    PeopleModel findById(UUID id);
    PeopleModel create(PeopleDTO peopleDTO);
    PeopleModel update (PeopleDTO peopleDTO);
    void deleteById(UUID id);
    
}
