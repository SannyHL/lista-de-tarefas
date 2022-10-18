package com.br.todolist.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;

}
