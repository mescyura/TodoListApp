package com.todo.todolistapp.dto.task;

import com.todo.todolistapp.dto.comment.CommentResponseDto;
import com.todo.todolistapp.dto.project.ProjectDTO;
import com.todo.todolistapp.enums.Priority;
import com.todo.todolistapp.enums.Status;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TaskVO {
    private int id;
    private String name;
    private String description;
    private String created;
    private String updated;
    private String dueDate;
    private Status status;
    private Priority priority;
    private int progress;
    private List<CommentResponseDto> commentsList;
    private ProjectDTO project;

}
