package com.simple_crud.simp_crud.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private long id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
}
