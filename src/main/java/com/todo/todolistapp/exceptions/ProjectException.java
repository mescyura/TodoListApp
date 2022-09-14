package com.todo.todolistapp.exceptions;

public class ProjectException extends Exception {

    public ProjectException(String message) {
        super(message);
    }

    public static String NotFoundException(long id) {
        return "Project with id " + id + " not found!";
    }

    public static String ProjectAlreadyExists() {
        return "Project with given name already exists!";
    }

}
