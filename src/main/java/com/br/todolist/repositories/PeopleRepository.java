package com.br.todolist.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.br.todolist.models.PeopleModel;

public interface PeopleRepository extends JpaRepository<PeopleModel, Long>{

    
}
