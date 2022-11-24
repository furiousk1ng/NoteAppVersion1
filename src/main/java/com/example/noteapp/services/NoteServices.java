package com.example.noteapp.services;

import com.example.noteapp.entities.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

@Service
public class NoteServices {
    List<Note> list;

    public NoteServices() {
        list = new ArrayList<>();
        list.add(new Note(1L, "Note 1", "skdkas"));
        list.add(new Note(2L, "note2", "sadsasad"));

    }

    public List<Note> getNotes() throws Exception {
        if (list.isEmpty()) {
            throw new Exception();
        }
        return list;
    }

    public void putNote(Note note) throws Exception {

        if (list.contains(note) || note.getId() == 0) {
            throw new Exception();
        } else {
            list.add(note);
            list.sort(idcompare);
        }
    }

    public Note getNote(Long noteId) throws Exception {
        if(noteId > list.size() || noteId == 0){
            throw new Exception();
        }
        Note n = null;
        for(Note note: list){
                if(note.getId() == noteId)
                {
                    n = note;
                    break;
                }

        }
        return n;
    }



    public void deleteNote(long noteId) throws Exception {
        int id;
        if(list.isEmpty() ||  noteId == 0){
            throw new Exception();
        }
        else {
        for(Note n: list){

                if ((n.getId()) == noteId) {
                    id = list.indexOf(n);
                    list.remove(id);
                    list.sort(idcompare);
                    break;
                }
            }
        }
    }

    public void editNote(Long noteId, String namenote, String descrnote) throws Exception {
        if(noteId > list.size() ||  noteId == 0){
            throw new Exception();
        }
        for(Note note: list){

                if (note.getId() == noteId) {
                    note.setNamenote(namenote);
                    note.setDescrnote(descrnote);
                    break;
                }

        }
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
