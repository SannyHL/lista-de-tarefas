package com.br.todolist.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.todolist.dtos.PeopleDTO;
import com.br.todolist.services.PeopleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/people")
@Api(tags = "API Controller")
public class PeopleController {
    
    @Autowired
    private PeopleService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ApiOperation("Listen all")
    public ResponseEntity<List<PeopleDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().map(x -> mapper.map(x, PeopleDTO.class)).collect(Collectors.toList()));
    }

}
