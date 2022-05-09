package com.learn.java.basic.view;

import com.learn.java.basic.entity.Notebook;
import com.learn.java.basic.entity.Note;

import java.util.List;

public class PrintNoteView {

    public void print(List<Note> notes) {
        int i = 1;
        for (Note note : notes) {
            System.out.println("Note " + i + ": " + note);
            i++;
        }
        System.out.println("");
    }

    public void print(Note note) {
        System.out.println("Note : " + note);
        System.out.println("");
    }

    public void print(Notebook notebook) {
        List<Note> notes = notebook.getNotes();
        print(notes);
        System.out.println("");
    }

}
