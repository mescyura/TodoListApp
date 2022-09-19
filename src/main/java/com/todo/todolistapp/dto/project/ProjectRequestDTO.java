package com.todo.todolistapp.dto.project;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProjectRequestDTO {
    private long id;
    @NotNull
    @NotBlank
    @NotEmpty(message = "name cannot be empty")
    private String name;
    private String description;


}
