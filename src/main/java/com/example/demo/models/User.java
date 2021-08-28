package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Table(name = "User")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class User implements Comparable<User> {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
//        System.out.println(this);
        return this.getId() - o.getId();
//        return this.getName().compareTo(o.getName());
    }
}
