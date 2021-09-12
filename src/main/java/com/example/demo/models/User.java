package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Table(name = "User")
@Entity
@Getter
@Setter
@ToString(exclude = {"car"})
@NoArgsConstructor

public class User {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private Car car;

    private String email;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }


    public User(int id, String name, Car car) {
        this.id = id;
        this.name = name;
        this.car = car;
    }

    public User(String name) {
        this.name = name;
    }

}
