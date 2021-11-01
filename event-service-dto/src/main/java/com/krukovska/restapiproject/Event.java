package com.krukovska.restapiproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "place")
    private String place;

    @Column(name = "speaker")
    private String speaker;

    @Column(name = "eventType")
    private String eventType;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

}
