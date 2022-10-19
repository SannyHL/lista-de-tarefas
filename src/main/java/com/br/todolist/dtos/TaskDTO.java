package com.br.todolist.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.todolist.enums.LevelOfImportance;
import com.br.todolist.enums.TypesOfTask;
import com.br.todolist.models.PeopleModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private TypesOfTask type;
    private String description;
    private LevelOfImportance importance;
    private String addressTask;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateTask;
    private PeopleModel people;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreateTask;
}
