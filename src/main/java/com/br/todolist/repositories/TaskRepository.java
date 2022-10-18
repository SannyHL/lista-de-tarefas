package com.br.todolist.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.br.todolist.models.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long>{
    
}
