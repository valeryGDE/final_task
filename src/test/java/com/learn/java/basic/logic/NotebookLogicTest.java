package com.learn.java.basic.logic;

import com.learn.java.basic.entity.Note;
import com.learn.java.basic.view.PrintNoteView;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

public class NotebookLogicTest {

    @Test
    public void noteWithContextIsAddedSuccessfully() {
        NotebookLogic logic = new NotebookLogic();
        PrintNoteView view = new PrintNoteView();

        logic.addNote("I love cats");
        assertTrue(logic.getNotebook().getNotes().stream().anyMatch(note -> note.getContext().contentEquals("I love cats")));
    }

    @Test
    public void noteWithContextAndDateIsAddedSuccessfully() {
        NotebookLogic logic = new NotebookLogic();
        PrintNoteView view = new PrintNoteView();
        Date date = new Date();

        logic.addNote("I love cats", date);
        assertTrue(logic.getNotebook().getNotes().stream().anyMatch(note -> note.getContext().contentEquals("I love cats") && note.getDate().equals(date)));
    }

    @Test
    public void noteIsRemovedSuccessfully() {
        NotebookLogic logic = new NotebookLogic();
        PrintNoteView view = new PrintNoteView();
        logic.addNote("I love cats");

        logic.remove("I love cats");
        assertFalse(logic.getNotebook().getNotes().stream().anyMatch(note -> note.getContext().contentEquals("I love cats")));
    }

    @Test
    public void noteIsEditedSuccessfully() {
        NotebookLogic logic = new NotebookLogic();
        PrintNoteView view = new PrintNoteView();

        logic.addNote("I love cats");
        int index = logic.getNotebook().getNotes().indexOf(new Note("I love cats"));
        logic.editNote("cats", "dogs");
        assertTrue(logic.getNotebook().getNotes().get(index).getContext().contentEquals("I love dogs"));
    }

    @Test
    public void noteIsFoundByContext() {
        NotebookLogic logic = new NotebookLogic();
        PrintNoteView view = new PrintNoteView();

        logic.addNote("I love cats");
        logic.addNote("I love dogs");
        List<Note> results = logic.searchByContext("love");
        assertEquals(results.size(), 2);
    }

    @Test
    public void noteIsFoundByDate() {
        NotebookLogic logic = new NotebookLogic();
        PrintNoteView view = new PrintNoteView();

        Date date = new Date();
        logic.addNote("I love cats", date);
        List<Note> results = logic.searchByDate("May");
        assertEquals(results.size(), 1);
    }
}