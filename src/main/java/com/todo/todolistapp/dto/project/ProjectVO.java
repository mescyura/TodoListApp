package com.todo.todolistapp.dto.project;

import com.todo.todolistapp.dto.task.TaskDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProjectVO {
    private Long id;
    private String name;
    private String description;
    private String created;
    private String updated;
    private List<TaskDTO> taskList;

    @Override
    public String toString() {
        return "ProjectVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
