package com.example.noteapp.services;

import com.example.noteapp.db.NoteDb;
import com.example.noteapp.entities.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

@Service
public class NoteServices {

    @Autowired
    private NoteDb noteDb;

    public List<Note> getNotes()  {
        return noteDb.findAll();
    }

    public void putNote(Note note)  {

        noteDb.save(note);
    }

    public Note getNote(long noteId)  {

        return noteDb.getReferenceById(noteId);
    }



    public void deleteNote(long noteId)  {

        Note note = noteDb.getReferenceById(noteId);
        noteDb.delete(note);
    }

    public void editNote(Note note) {

        noteDb.save(note);
    }

    Comparator<Note> idcompare = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            if(o1.getId()< o2.getId()){
                return -1;
            } else if (o1.getId()>o2.getId()) {
                return 1;
            }
            else
                return 0;
        }
    };
}
