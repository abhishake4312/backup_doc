package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getAll()
    {
        return speakerRepository.findAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    public Speaker find(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker){
        return  speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method=RequestMethod.PUT)
    public Speaker update(@PathVariable Long id , @RequestBody Speaker speaker){
        Speaker existingSpeaker= speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return  speakerRepository.saveAndFlush(existingSpeaker);
    }
}
