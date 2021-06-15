/*
package com.online.movieticketbookingapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shows implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;
    private String movieName;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    @CreationTimestamp
    @JsonFormat(pattern = "HH:mm:ss a", shape = JsonFormat.Shape.STRING)
    private LocalTime showStartTime;
    @CreationTimestamp
    @JsonFormat(pattern = "HH:mm:ss a", shape = JsonFormat.Shape.STRING)
    private LocalTime showEndTime;
    @JsonIgnore
    @ManyToOne(targetEntity = Screens.class)
    @JoinTable(name = "screen_shows", joinColumns = {@JoinColumn(name = "showId")},
            inverseJoinColumns = {@JoinColumn(name = "screenId")})
    private Screens screens;
}
*/
