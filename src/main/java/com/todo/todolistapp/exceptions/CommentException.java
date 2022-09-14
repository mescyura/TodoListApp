package com.todo.todolistapp.exceptions;

public class CommentException extends Exception {

    public CommentException(String message) {
        super(message);
    }

    public static String NotFoundException(long id) {
        return "Comment with id " + id + " not found!";
    }

    public static String CommentAlreadyExists() {
        return "Comment with given name already exists!";
    }
}