package com.example.noteapp.controller;

import com.example.noteapp.entities.Note;
import com.example.noteapp.services.NoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteServices noteServices;

    @PostMapping("/add")
    public void addNote(@RequestBody Note note) throws Exception {
        noteServices.putNote(note);
    }
    @GetMapping("/allnotes")
    public List<Note> getNotes()  {
        return noteServices.getNotes();
    }
    @GetMapping("/allnotes/{noteId}")
    public Note getOneNote(@PathVariable String noteId)  {
        return noteServices.getNote(Long.parseLong(noteId));
    }
    @PostMapping("/allnotes/{noteId}")
    public void delNote(@PathVariable String noteId)  {
         noteServices.deleteNote(Long.parseLong(noteId));
    }
    @PutMapping("/allnotes")
    public void editNote(@RequestBody Note note)  {
        noteServices.editNote(note);
    }

}
