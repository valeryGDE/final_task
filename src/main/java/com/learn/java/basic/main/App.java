package com.learn.java.basic.main;

import com.learn.java.basic.logic.NotebookLogic;
import com.learn.java.basic.view.PrintNoteView;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        NotebookLogic logic = new NotebookLogic();
        PrintNoteView view = new PrintNoteView();

        logic.addNote("I love cats");
        logic.addNote("I love Java", new Date());
        logic.addNote("You should learn Java", new Date());

        view.print(logic.getNotebook());

        view.print(logic.searchByContext("Java"));
        view.print(logic.searchByDate("Nov"));

        logic.editNote("Java", "Lama");
        view.print(logic.getNotebook());

        logic.remove("Java");
        view.print(logic.getNotebook());
    }
}
