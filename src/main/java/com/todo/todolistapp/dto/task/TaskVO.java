package com.todo.todolistapp.dto.task;

import com.todo.todolistapp.dto.comment.CommentDTO;
import com.todo.todolistapp.dto.comment.CommentRequestDTO;
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
    private List<CommentDTO> comments;
    private ProjectDTO project;

    @Override
    public String toString() {
        return "TaskVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", progress=" + progress +
                ", comments=" + comments +
                ", project=" + project +
                '}';
    }
}
