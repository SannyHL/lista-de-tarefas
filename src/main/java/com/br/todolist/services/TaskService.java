package com.br.todolist.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.todolist.dtos.TaskDTO;
import com.br.todolist.exceptions.ObjectNotFoundException;
import com.br.todolist.interfaces.TaskServiceInteface;
import com.br.todolist.models.TaskModel;
import com.br.todolist.repositories.TaskRepository;

@Service
public class TaskService implements TaskServiceInteface{

    @Autowired
    private TaskRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TaskModel> findAll() {
        return repository.findAll();
    }

    @Override
    public TaskModel findById(Long id) {
        Optional<TaskModel> taskOptional = repository.findById(id);
        return taskOptional.orElseThrow(() -> new ObjectNotFoundException("Tarefa não encontrada! Tente novamente..."));
    }

    @Override
    public TaskModel create(TaskDTO taskDTO) {
        return repository.save(mapper.map(taskDTO, TaskModel.class));
    }

    @Override
    public TaskModel update(TaskDTO taskDTO) {
        return repository.save(mapper.map(taskDTO, TaskModel.class));
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }
    
}
