package com.todo.todolistapp.dto.task;

import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.enums.Priority;
import com.todo.todolistapp.enums.Status;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskRequestDTO {
    @NotNull
    @NotBlank
    @NotEmpty(message = "name cannot be empty")
    private String name;
    private String description;
    private String dueDate;
    private Status status;
    private Priority priority;
    private int progress;
    private ProjectRequestDTO project;
}
