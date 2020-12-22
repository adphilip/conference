package com.adphilip.conf.conference.repositories;

import com.adphilip.conf.conference.models.Speaker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{
    
}
