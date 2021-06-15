package com.online.movieticketbookingapp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;
    private String theaterName;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addressId")
    private Address addresses;
    @ManyToOne(targetEntity = Movie.class)
    @JoinTable(name = "theater_movie", joinColumns = {@JoinColumn(name="theaterId")},
    inverseJoinColumns = {@JoinColumn(name="movieId")})
    private Movie movie;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="screenId")
    private Screens screens;
}
