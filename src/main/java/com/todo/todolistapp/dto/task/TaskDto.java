package com.todo.todolistapp.dto.task;

import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.enums.Priority;
import com.todo.todolistapp.enums.Status;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Getter
@Setter
@Builder
public class TaskDto {
    private int id;
    private String name;
    private String description;
    private String dueDate;
    private Status status;
    private Priority priority;
    private int progress;
    private ProjectDto project;

    public TaskDto() {
    }

    public TaskDto(int id, String name, String description, String dueDate, Status status, Priority priority, int progress, ProjectDto project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.progress = progress;
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return Objects.equals(name, taskDto.name) && Objects.equals(description, taskDto.description) && Objects.equals(dueDate, taskDto.dueDate) && status == taskDto.status && priority == taskDto.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, dueDate, status, priority);
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
