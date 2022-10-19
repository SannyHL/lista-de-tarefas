package com.br.todolist.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.todolist.enums.LevelOfImportance;
import com.br.todolist.enums.TypesOfTask;
import com.br.todolist.models.PeopleModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    
    @JsonIgnore
    private Long id;
    private TypesOfTask type;
    private String description;
    private LevelOfImportance importance;
    private String addressTask;
    private LocalDate dateTask;
    private PeopleModel people;
    @JsonIgnore
    private LocalDateTime dateCreateTask;
}
