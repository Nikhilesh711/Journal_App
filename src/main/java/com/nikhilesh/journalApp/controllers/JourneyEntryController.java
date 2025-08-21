//package com.nikhilesh.journalApp.controllers;
//
//import com.nikhilesh.journalApp.beans.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JourneyEntryController {
//
//    private Map<Long , JournalEntry> journalEntries = new HashMap<>();
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry journalEntry){
//        journalEntries.put(journalEntry.getId() , journalEntry);
//        return true;
//    }
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable long myId){
//        return journalEntries.get(myId);
//    }
//
//    @PutMapping("id/{myId}")
//    public boolean modfiyJournalEntryById(@PathVariable long myId , @RequestBody JournalEntry journalEntry){
//        journalEntries.put(myId , journalEntry);
//        return true;
//    }
//
//    @DeleteMapping("id/{myId}")
//    public boolean deleteJournalEntryById(@PathVariable long myId){
//        journalEntries.remove(myId);
//        return true;
//    }
//
//}
