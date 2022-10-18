package com.br.todolist.interfaces;

import java.util.List;

import com.br.todolist.dtos.TaskDTO;
import com.br.todolist.models.TaskModel;

public interface TaskServiceInteface {

    List<TaskModel> findAll();
    TaskModel findById(Long id);
    TaskModel create(TaskDTO taskDTO);
    TaskModel update(TaskDTO taskDTO);
    void deleteById(Long id);
    
}
