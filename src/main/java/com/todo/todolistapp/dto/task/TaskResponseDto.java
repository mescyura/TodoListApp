package com.todo.todolistapp.dto.task;

import com.todo.todolistapp.dto.comment.CommentResponseDto;
import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.enums.Priority;
import com.todo.todolistapp.enums.Status;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Data
@Getter
@Setter
@Builder
public class TaskResponseDto {
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
    private ProjectDto project;

    public TaskResponseDto() {
    }

    public TaskResponseDto(int id, String name, String description, String created, String updated, String dueDate, Status status, Priority priority, int progress, List<CommentResponseDto> commentsList, ProjectDto project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.progress = progress;
        this.commentsList = commentsList;
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskResponseDto that = (TaskResponseDto) o;
        return id == that.id && progress == that.progress && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated) && Objects.equals(dueDate, that.dueDate) && status == that.status && priority == that.priority && Objects.equals(commentsList, that.commentsList) && Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created, updated, dueDate, status, priority, progress, commentsList, project);
    }

    @Override
    public String toString() {
        return "TaskResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", progress=" + progress +
                ", commentsList=" + commentsList +
                ", project=" + project +
                '}';
    }
}
