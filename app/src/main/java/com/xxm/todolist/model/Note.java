package com.xxm.todolist.model;

import java.util.Date;

public class Note {
    private final long id;
    private Date date;
    private State state;
    private String content;

    public Note(long id) {
        this.id = id;
    }

    public Note(int id, Date date, State state, String content) {
        this.id = id;
        this.state = state;
        this.date = date;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return  this.date;
    }

    public State getState() {
        return this.state;
    }

    public String getContent() {
        return this.content;
    }

    public enum  State {
        TODO,
        DONE;

        public static int getIntValue(State state) {
            if (state == TODO) {
                return 0;
            } else {
                return 1;
            }
        }

        public static State from(int intValue) {
            if (intValue == 1) {
                return DONE;
            } else {
                return TODO;
            }
        }
    }
}
