package com.learn.java.basic.repository;

import com.learn.java.basic.entity.Notebook;

import java.util.ArrayList;
import java.util.List;

public class NotebookProvider {
    private static final NotebookProvider notebookInstance = new NotebookProvider();

    private List<Notebook> notebooks = new ArrayList<>();

    private NotebookProvider() {
        notebooks.add(new Notebook());
    }

    public Notebook getNotebook(int index) {
        if (index >= notebooks.size()) {
            throw new RuntimeException("No such notebook");
        }
        return notebooks.get(index);
    }

    public static NotebookProvider getNotebookInstance() {
        return notebookInstance;
    }

    public void addNewNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public void createNotebook() {
        Notebook notebook = new Notebook();
        notebooks.add(notebook);
    }
}
