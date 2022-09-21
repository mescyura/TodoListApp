package com.todo.todolistapp.exceptions;

public class CommentException extends Exception {

    public CommentException(String message) {
        super(message);
    }

    public static String NotFoundException(long id) {
        return "Comment with id " + id + " not found!";
    }

    public static String CommentIsNull(long id) {
        return "Comment body with id " + id + " is null!";
    }

}