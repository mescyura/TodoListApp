package com.todo.todolistapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = -8366835974390941850L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private Set<Task> tasksSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(description, project.description) && Objects.equals(created, project.created) && Objects.equals(updated, project.updated) && Objects.equals(tasksSet, project.tasksSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created, updated, tasksSet);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", tasksSet=" + tasksSet +
                '}';
    }
}
