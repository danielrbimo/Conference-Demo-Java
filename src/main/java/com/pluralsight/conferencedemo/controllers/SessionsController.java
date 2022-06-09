package com.pluralsight.conferencedemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;



@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    //This will create a new session and if you pass a session info to the API endpoint, 
    //it'll create a new session into the database
    //The PostMapping is saying that we're requiring the HTTP verb POST to be presented with this API call.
    @PostMapping
    public Session create(@RequestBody final Session session) {
        //The RequestBody is taking in all of the attributes in a JSON payload and automatically
        //marshalling them into a session object.
        //It doesn't get commited to the database until it's flushed. 
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }

    //TRY TO IMPLEMENT LOGIC THAT ALLOWS THE DELETION OF CHILDREN RECORDS FOR SESSIONS

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        //because this is a PUT, we expect all attributes to be passed in.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = sessionRepository.getOne(id);
        //BeanUtils object takes the existingSession and copies the incoming session data onto it. 
        //The third parameter on the copyProperties method allow us to ignore properties on the entitires or Java object that we do not
        //want to copy over from one to the other. We want to ignore it because it's the primary key and don't want to replace it.
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);

    }


}
