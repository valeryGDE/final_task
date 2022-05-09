package com.learn.java.basic.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notebook {

    private List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public int size() {
        return notes.size();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void add(Note note) {
        notes.add(note);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(notes, notebook.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "notes=" + notes +
                '}';
    }
}
