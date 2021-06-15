package com.online.movieticketbookingapp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String userId;
    private String fullName;
    private String mobileNumber;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;
}
