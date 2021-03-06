package com.adphilip.conf.conference.controllers;

import java.util.List;

import com.adphilip.conf.conference.models.Session;
import com.adphilip.conf.conference.repositories.SessionRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

   // @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
   @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    //@RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @PutMapping(value = "{id}")
    public Session update(@PathVariable Long id, @RequestBody final Session session){

        //TODO - validation for params
        Session sessionUpdated =  sessionRepository.getOne(id);
        //session_id will be ignored when will copy the data because se want to keep the initial PK
        BeanUtils.copyProperties(session, sessionUpdated, "session_id");
        return sessionRepository.saveAndFlush(sessionUpdated);
    }

}
