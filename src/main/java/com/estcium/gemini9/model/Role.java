package com.estcium.gemini9.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1)
public class Role {
    private static String ROLE_PREFIX = "ROLE_";

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "role_id_seq")
    private Integer id;


    private String name;

    //private Set<User> users;

    public String getName() {
        return ROLE_PREFIX+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
