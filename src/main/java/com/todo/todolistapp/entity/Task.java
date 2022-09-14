package com.todo.todolistapp.entity;

import com.todo.todolistapp.enums.Priority;
import com.todo.todolistapp.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Setter
@Getter
@Entity
@Table(name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = 7823533028449594429L;

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
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dueDate;
    // default status
    @Enumerated(EnumType.STRING)
    private Status status = Status.TODO;
    //default priority
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.NORMAL;
    private int progress;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return progress == task.progress && Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(created, task.created) && Objects.equals(updated, task.updated) && Objects.equals(dueDate, task.dueDate) && status == task.status && priority == task.priority && Objects.equals(comments, task.comments) && Objects.equals(project, task.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created, updated, dueDate, status, priority, progress, comments, project);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                ", progress=" + progress +
                ", comments=" + comments +
                ", project=" + project +
                '}';
    }
}
