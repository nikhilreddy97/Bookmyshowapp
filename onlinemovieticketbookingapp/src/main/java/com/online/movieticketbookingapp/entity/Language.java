package com.online.movieticketbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Language implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer languageId;
    private String language;
    @JsonIgnore
    @ManyToMany(mappedBy = "languages", fetch = FetchType.LAZY)
    private List<Movie> movies;
}
