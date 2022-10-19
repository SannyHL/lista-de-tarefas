package com.br.todolist.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.br.todolist.enums.LevelOfImportance;
import com.br.todolist.enums.TypesOfTask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="task")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
    
    private TypesOfTask type;
    private String description;
    private LevelOfImportance importance;
    private String addressTask;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateTask;
    private LocalDateTime dateCreateTask;
    
    @ManyToOne
    @JoinColumn(name="people_id")
    private PeopleModel people;
}
