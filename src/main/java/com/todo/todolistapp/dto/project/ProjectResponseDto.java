package com.todo.todolistapp.dto.project;


import com.todo.todolistapp.dto.task.TaskResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Data
@Getter
@Setter
@Builder
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private String created;
    private String updated;
    private Set<TaskResponseDto> tasksSet;

    public ProjectResponseDto() {
    }

    public ProjectResponseDto(Long id, String name, String description, String created, String updated, Set<TaskResponseDto> tasksSet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.tasksSet = tasksSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectResponseDto that = (ProjectResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated) && Objects.equals(tasksSet, that.tasksSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created, updated, tasksSet);
    }

    @Override
    public String toString() {
        return "ProjectResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", tasksSet=" + tasksSet +
                '}';
    }
}
