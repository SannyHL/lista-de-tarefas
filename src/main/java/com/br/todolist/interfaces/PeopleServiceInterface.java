package com.br.todolist.interfaces;

import java.util.List;


import com.br.todolist.dtos.PeopleDTO;
import com.br.todolist.models.PeopleModel;

public interface PeopleServiceInterface {

    List<PeopleModel> findAll();
    PeopleModel findById(Long id);
    PeopleModel create(PeopleDTO peopleDTO);
    PeopleModel update (PeopleDTO peopleDTO);
    void deleteById(Long id);
    
}
