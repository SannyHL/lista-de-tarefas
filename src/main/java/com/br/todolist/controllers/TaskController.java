package com.br.todolist.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.todolist.dtos.TaskDTO;
import com.br.todolist.models.TaskModel;
import com.br.todolist.services.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/task")
@Api(tags = "Task Controller")
@CrossOrigin
public class TaskController {

    
    private static final String ID = "/{id}";
    @Autowired
    private TaskService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ApiOperation("List all")
    public ResponseEntity<List<TaskDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().map(x -> mapper.map(x, TaskDTO.class)).collect(Collectors.toList()));
    }

    @GetMapping(ID)
    @ApiOperation("Find by id")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(mapper.map(service.findById(id), TaskDTO.class));
    }

    @PostMapping
    @ApiOperation("Create")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO){
        taskDTO.setDateCreateTask(LocalDateTime.now(ZoneId.of("UTC-3")));
        TaskModel taskModel = service.create(taskDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(taskModel.getId()).toUri();
        return ResponseEntity.created(uri).body(taskDTO);
    }

    @DeleteMapping(ID)
    @ApiOperation("Delete")
    public ResponseEntity<TaskDTO> deleteById(@PathVariable Long id) throws Exception{
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(ID)
    @ApiOperation("Update")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO) throws Exception {
        findById(id);
        taskDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(taskDTO), TaskDTO.class));
    }

}
