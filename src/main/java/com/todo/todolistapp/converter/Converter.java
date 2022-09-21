package com.todo.todolistapp.converter;

import com.todo.todolistapp.dto.comment.CommentDTO;
import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.entity.Comment;
import com.todo.todolistapp.entity.Project;
import com.todo.todolistapp.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Converter {

    Logger logger = LoggerFactory.getLogger(Converter.class);

    //TODO deal with time conversion
    public static String dateConverter(LocalDateTime time) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String date = time.format(dateTimeFormatter);
        return date;
    }

    public static LocalDateTime dateConverter(String  time) {
        return LocalDateTime.parse(time);
    }


}
