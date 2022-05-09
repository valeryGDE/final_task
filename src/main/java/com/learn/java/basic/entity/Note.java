package com.learn.java.basic.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Note implements Serializable {
    private String context;
    private Date date;

    public Note() {
        this.context = null;
        this.date = null;
    }

    public Note(String context) {
        this.context = context;
        this.date = null;
    }

    public Note(String context, Date date) {
        this.context = context;
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public Date getDate() {
        return date;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(context, note.context) && Objects.equals(date, note.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, date);
    }

    @Override
    public String toString() {
        return "Note{" +
                "context='" + context + '\'' +
                ", date=" + date +
                '}';
    }
}
