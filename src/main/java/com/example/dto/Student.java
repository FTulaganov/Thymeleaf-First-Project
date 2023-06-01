package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String id;
    private String surname;
    private String name;

    public Student() {
    }

    public Student(String id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }
}
