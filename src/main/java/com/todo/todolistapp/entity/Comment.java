package com.todo.todolistapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Data
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = -6222211656201929810L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(id, comment1.id) && Objects.equals(comment, comment1.comment) && Objects.equals(created, comment1.created) && Objects.equals(updated, comment1.updated) && Objects.equals(task, comment1.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, created, updated, task);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", task=" + task +
                '}';
    }
}
