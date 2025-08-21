package com.nikhilesh.journalApp.controllers;

import com.nikhilesh.journalApp.beans.JournalEntry;
import com.nikhilesh.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JourneyEntryControllerV2 {

    @Autowired
    JournalEntryService journalEntryService;

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry){
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(journalEntry);
        return journalEntry;
    }

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.getById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry modfiyJournalEntryById(@PathVariable ObjectId myId , @RequestBody JournalEntry newJournalEntry){
        JournalEntry old = journalEntryService.getById(myId).orElse(null);
        if(old != null){
            old.setTitle(newJournalEntry.getTitle() != null && !newJournalEntry.getTitle().equals("") ? newJournalEntry.getTitle() : old.getTitle() );
            old.setContent(newJournalEntry.getContent() != null && !newJournalEntry.getContent().equals("") ? newJournalEntry.getContent() : old.getContent() );
        }
        journalEntryService.saveEntry(old);
        return old;
    }

}
