package com.adphilip.conf.conference.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

@Data
@Entity(name = "sessions") // "sessions" - DB table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
 
    //not need to be annotated;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;
    @Column(name = "session_length")
    private Integer sessionLength;

    @ManyToMany
    @JoinTable(
        name="session_speakers",
        joinColumns = @JoinColumn(name = "session_id"),
        inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    List<Speaker> speakers;

    public Session() {
        //default constructor
    }
    
}
