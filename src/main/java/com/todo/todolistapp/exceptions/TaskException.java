package com.todo.todolistapp.exceptions;

public class TaskException extends Exception {

    public TaskException(String message) {
        super(message);
    }

    public static String NotFoundException(long id) {
        return "Task with id " + id + " not found!";
    }

    public static String TaskAlreadyExists() {
        return "Task with given name already exists!";
    }

}
