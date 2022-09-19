package com.todo.todolistapp.dto.project;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private String created;
    private String updated;

}
