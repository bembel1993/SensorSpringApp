package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sensor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String names;

    @Column(name = "model")
    private String models;

    @Column(name = "type")
    private String types;

    @Column(name = "range")
    private String ranges;

    @Column(name = "unit")
    private String units;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;
}
