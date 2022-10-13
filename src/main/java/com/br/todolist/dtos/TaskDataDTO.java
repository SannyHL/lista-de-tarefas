package com.br.todolist.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.todolist.enums.LevelOfImportance;
import com.br.todolist.enums.TypesOfTask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDataDTO {
    
    private UUID id;
    private TypesOfTask type;
    private String description;
    private LevelOfImportance importance;
    private String addressTask;
    private LocalDateTime dateTask;
    private LocalDateTime dateCreateTask;
}
