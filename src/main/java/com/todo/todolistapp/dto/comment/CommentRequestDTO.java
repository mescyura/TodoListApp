package com.todo.todolistapp.dto.comment;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentRequestDTO {
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty(message = "comment cannot be empty")
    private String comment;

}
