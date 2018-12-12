package com.example.demo.domain.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int user_id;

    @Column
    private String username;

    @Column
    private String user_password;
}
