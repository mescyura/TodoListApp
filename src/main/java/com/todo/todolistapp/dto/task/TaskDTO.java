package com.todo.todolistapp.dto.task;

import com.todo.todolistapp.enums.Priority;
import com.todo.todolistapp.enums.Status;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TaskDTO {
    private int id;
    private String name;
    private String description;
    private String created;
    private String updated;
    private String dueDate;
    private Status status;
    private Priority priority;
    private int progress;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", progress=" + progress +
                '}';
    }
}
