package com.xxm.todolist;

import com.xxm.todolist.model.Note;

public interface NoteOperator {
    void deleteNote(Note note);

    void updateNote(Note note);
}
