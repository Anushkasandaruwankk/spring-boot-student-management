package com.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String address;
    private String imagePath;
    private int age;
    private School school;
    private List<SportsClub> sportsClubs;
}
