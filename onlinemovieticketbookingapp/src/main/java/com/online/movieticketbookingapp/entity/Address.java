package com.online.movieticketbookingapp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private Integer streetNo;
    private String area;
    private String city;
    private String state;
    private String pincode;
    @OneToOne
    @JoinColumn(name = "theaterId")
    private Theater theaters;
}
