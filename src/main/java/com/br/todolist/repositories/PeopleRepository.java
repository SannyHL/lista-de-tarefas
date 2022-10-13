package com.br.todolist.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.todolist.models.TaskDataModel;

public interface PeopleRepository extends JpaRepository<TaskDataModel, UUID>{

    
}
