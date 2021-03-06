package com.user.service.model;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int age;
}
