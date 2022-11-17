package org.demo;

import javax.persistence.*;

@Entity
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //I suppose you use postgres
    private Long id;

    @OneToOne(mappedBy = "reading", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Sensor sensorId;
}

@Entity
class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //I suppose you use postgres
    @Column(name = "sensor_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "sensor_id")
    private Reading reading;
}
