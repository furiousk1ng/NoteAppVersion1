package com.example.noteapp.entities;

import lombok.Data;

@Data
public class Note {
    private Long id;
    private String namenote;
    private String descrnote;

    public Note(Long id, String namenote, String descrnote) {
        this.id = id;
        this.namenote = namenote;
        this.descrnote = descrnote;
    }



}
