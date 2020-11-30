package com.adphilip.conf.conference.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.Data;

//import org.hibernate.annotations.Type;

@Data
@Entity(name="speakers")
public class Speaker {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_speaker;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob
    @org.hibernate.annotations.Type(type = "org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    @ManyToMany(mappedBy = "speakers")
    List<Session> sessions;

    public Speaker() {
    }

    
}