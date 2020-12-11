package com.adphilip.conf.conference.controllers;

import java.util.List;

import com.adphilip.conf.conference.models.Speaker;
import com.adphilip.conf.conference.repositories.SpeakerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {
    
@Autowired
private SpeakerRepository speakerRepository;

@GetMapping
public List<Speaker> list(){
    return speakerRepository.findAll();
}

@GetMapping
@RequestMapping("{id}")
public Speaker get(@PathVariable Integer id) {
    return speakerRepository.getOne(id);
}

@RequestMapping("id")
public void delete(@PathVariable Integer id){
    speakerRepository.deleteById(id);
}

@RequestMapping(value = "id", method = RequestMethod.PUT)
public Speaker update(@PathVariable Integer id, Speaker speaker){
    Speaker updatedSpeaker = speakerRepository.getOne(id);
    BeanUtils.copyProperties(speaker, updatedSpeaker, "speaker_id");

    return speakerRepository.saveAndFlush(updatedSpeaker);
}

}
