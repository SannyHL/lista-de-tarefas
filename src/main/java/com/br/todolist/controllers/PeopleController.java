package com.br.todolist.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.todolist.dtos.PeopleDTO;
import com.br.todolist.models.PeopleModel;
import com.br.todolist.services.PeopleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/people")
@Api(tags = "People Controller")
public class PeopleController {
    
    /**
     *
     */
    private static final String ID = "/{id}";
    @Autowired
    private PeopleService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ApiOperation("List all")
    public ResponseEntity<List<PeopleDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().map(x -> mapper.map(x, PeopleDTO.class)).collect(Collectors.toList()));
    }

    @GetMapping(ID)
    @ApiOperation("Find by id")
    public ResponseEntity<PeopleDTO> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok().body(mapper.map(service.findById(id), PeopleDTO.class));
    }

    @PostMapping
    @ApiOperation("Create")
    public ResponseEntity<PeopleDTO> create(@RequestBody PeopleDTO peopleDTO){
        PeopleModel peopleModel = service.create(peopleDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(peopleModel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(ID)
    @ApiOperation("Delete")
    public ResponseEntity<PeopleDTO> deleteById(@PathVariable Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(ID)
    @ApiOperation("Update")
    public ResponseEntity<PeopleDTO> update(@PathVariable Long id, @RequestBody PeopleDTO peopleDTO) throws Exception {
        findById(id);
        peopleDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(peopleDTO), PeopleDTO.class));
    }


}
