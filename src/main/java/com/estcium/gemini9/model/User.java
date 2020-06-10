package com.estcium.gemini9.model;

import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
public class User {



    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "users_id_seq")

    private Integer id;
    private String name;
    private String email;
    private String password;
    @Nullable
    private String fullname;
    @Nullable
    private String phone;
    @Nullable
    private String address;

    @ManyToOne()
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public User() {
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        if(role!=null) {
            list.add(new SimpleGrantedAuthority(role.getName()));
        }
        return list;
    }
}

