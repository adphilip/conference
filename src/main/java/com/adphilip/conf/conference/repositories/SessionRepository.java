package com.adphilip.conf.conference.repositories;

import com.adphilip.conf.conference.models.Session;

import org.springframework.data.jpa.repository.JpaRepository;

//CRUD operations are on Session Class now
public interface SessionRepository extends JpaRepository<Session, Integer>{
    
}
