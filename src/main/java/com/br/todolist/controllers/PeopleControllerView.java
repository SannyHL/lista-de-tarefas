package com.br.todolist.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.todolist.dtos.PeopleDTO;
import com.br.todolist.models.PeopleModel;
import com.br.todolist.services.PeopleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/registration")
@Api(tags = "People View Controller")
@CrossOrigin
public class PeopleControllerView {
    private static final String ID = "/{id}";
    @Autowired
    private PeopleService service;

    @GetMapping
    public String pagRegistration(){
        return "registration.html";
    }
    @PostMapping
    @ApiOperation("Create")
    public String createView(PeopleDTO peopleDTO){
        PeopleModel peopleModel = service.create(peopleDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(peopleModel.getId()).toUri();
        ResponseEntity.created(uri).build();
        return "registration.html";
    }

}
