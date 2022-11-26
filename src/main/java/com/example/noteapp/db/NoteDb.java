package com.example.noteapp.db;

import com.example.noteapp.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDb extends JpaRepository<Note, Long> {

}
