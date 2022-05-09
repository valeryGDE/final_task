package com.learn.java.basic.logic;

import com.learn.java.basic.entity.Notebook;
import com.learn.java.basic.entity.Note;
import com.learn.java.basic.repository.NotebookProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotebookLogic {

    private static final NotebookProvider provider = NotebookProvider.getNotebookInstance();

    private Notebook notebook;

    public NotebookLogic() {
        this.notebook = new Notebook();
        provider.addNewNotebook(notebook);
    }

    public NotebookLogic(int index) {
        this.notebook = provider.getNotebook(index);
    }

    public void setNotebook(int index) {
        this.notebook = provider.getNotebook(index);
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void addNote(String context) {
        notebook.add(new Note(context));
    }

    public void addNote(String context, Date date) {
        notebook.add(new Note(context, date));
    }


    public void remove(String context) {
        List<Note> notes = notebook.getNotes();
        List<Note> notesResult = new ArrayList<>();
        for (Note note : notes) {
            if (note.getContext().contains(context)) {
                notesResult.add(note);
            }
        }
        notes.removeAll(notesResult);
    }

    public void editNote(String context, String newContext) {
        List<Note> notes = notebook.getNotes();
        List<Note> notesResult = searchByContext(context);
        for (Note note : notesResult) {
            notes.set(notes.indexOf(note), new Note (note.getContext().replace(context, newContext)));
        }
    }

    public List<Note> searchByContext(String searchContext) {
        List<Note> notes = notebook.getNotes();
        List<Note> notesResult = new ArrayList<>();
        for (Note note : notes) {
            if (note.getContext().contains(searchContext)) {
                notesResult.add(note);
            }
        }
        return notesResult;
    }

    public List<Note> searchByDate(String date) {
        List<Note> notes = notebook.getNotes();
        List<Note> notesResult = new ArrayList<>();
        for (Note note : notes) {
            try {
                if (note.getDate().toString().contains(date)) {
                    notesResult.add(note);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong with searching by date for " + note.toString());
            }
        }
        return notesResult;
    }
}
