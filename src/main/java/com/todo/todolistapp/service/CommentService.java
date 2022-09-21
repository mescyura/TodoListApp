package com.todo.todolistapp.service;

import com.todo.todolistapp.dto.comment.CommentRequestDTO;
import com.todo.todolistapp.entity.Comment;
import com.todo.todolistapp.entity.Task;
import com.todo.todolistapp.exceptions.CommentException;
import com.todo.todolistapp.exceptions.TaskException;

public interface CommentService {

    /**
     * Save {@link Comment} to DB.
     *
     * @param taskId            - {@link Task} id.
     * @param commentRequestDTO - {@link CommentRequestDTO} entity.
     * @return nothing.
     */
    void addComment(CommentRequestDTO commentRequestDTO, long taskId) throws TaskException;

//    /**
//     * Save {@link Comment} to DB.
//     *
//     * @param comment - entity of {@link Comment}.
//     * @param task    - entity of {@link Task}.
//     * @return nothing.
//     */
//
//    void addComment(Comment comment, Task task);

    /**
     * Update {@link Comment} in DB.
     *
     * @param id                - {@link Comment} id.
     * @param commentRequestDTO - {@link CommentRequestDTO} entity.
     * @return nothing
     */
    void updateComment(CommentRequestDTO commentRequestDTO, long id) throws CommentException;

    /**
     * Delete {@link Comment} from DB by id.
     *
     * @param commentRequestDTO - {@link CommentRequestDTO} entity.
     * @return nothing
     */
    void deleteComment(CommentRequestDTO commentRequestDTO) throws CommentException;

//    /**
//     * Delete {@link Comment} from DB by id.
//     *
//     * @param id - {@link Comment} id.
//     * @return nothing
//     */
//    void deleteComment(long id) throws CommentException;


}
