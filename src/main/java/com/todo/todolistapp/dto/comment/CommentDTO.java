package com.todo.todolistapp.dto.comment;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CommentDTO {
    private Long id;
    private String comment;
    private String created;
    private String updated;

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
