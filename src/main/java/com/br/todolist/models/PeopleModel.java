package com.br.todolist.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="people")
public class PeopleModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private UUID id;
    
    private String name;
    private String password;
    @Email
    private String email;

}
