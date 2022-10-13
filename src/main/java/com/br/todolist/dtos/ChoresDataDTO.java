package com.br.todolist.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.todolist.enums.LevelOfImportance;
import com.br.todolist.enums.TypesOfChores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChoresDataDTO {
    
    private UUID id;
    private TypesOfChores type;
    private String description;
    private LevelOfImportance importance;
    private String addressChores;
    private LocalDateTime dateChore;
    private LocalDateTime dateCreateChore;
}
