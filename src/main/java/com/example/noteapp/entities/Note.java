package com.example.noteapp.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class Note {
    @Id
    private Long id;
    private String namenote;
    private String descrnote;

    public Note(Long id, String namenote, String descrnote) {
        this.id = id;
        this.namenote = namenote;
        this.descrnote = descrnote;
    }

    public Note() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
