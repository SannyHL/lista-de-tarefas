package com.br.todolist.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.br.todolist.models.TaskDataModel;

public interface TaskDataRepository extends JpaRepository<TaskDataModel, Long>{
    
}
