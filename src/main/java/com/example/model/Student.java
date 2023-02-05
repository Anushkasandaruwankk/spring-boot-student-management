package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private int age;
    @Lob
    @Column(name = "profile_image", columnDefinition="BLOB")
    private byte[] profileImage;
    @ManyToMany
    List<SportsClub> sportsClubs;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

}
