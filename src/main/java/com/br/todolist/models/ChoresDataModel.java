package com.br.todolist.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.todolist.enums.LevelOfImportance;
import com.br.todolist.enums.TypesOfChores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="chores")
public class ChoresDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private UUID id;
    
    private TypesOfChores type;
    private String description;
    private LevelOfImportance importance;
    private String addressChores;
    private LocalDateTime dateChore;
    private LocalDateTime dateCreateChore; 
}
