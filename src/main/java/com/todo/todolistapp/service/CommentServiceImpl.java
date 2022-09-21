package com.todo.todolistapp.service;

import com.todo.todolistapp.dto.comment.CommentRequestDTO;
import com.todo.todolistapp.entity.Comment;
import com.todo.todolistapp.entity.Task;
import com.todo.todolistapp.exceptions.CommentException;
import com.todo.todolistapp.exceptions.TaskException;
import com.todo.todolistapp.mapper.CommentMapper;
import com.todo.todolistapp.repository.CommentRepository;
import com.todo.todolistapp.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CommentServiceImpl implements CommentService {

    Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    private final CommentMapper commentMapper;

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper, CommentRepository commentRepository, TaskRepository taskRepository) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void addComment(CommentRequestDTO commentRequestDTO, long taskId) throws TaskException {
        logger.info("searching for a task with id - {}, to add comment", taskId);
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            Comment comment = commentMapper.toCommentEntity(commentRequestDTO);
            comment.setCreated(LocalDateTime.now());
            this.addComment(comment, task);
        } else {
            logger.warn("task with id - {} not found", taskId);
            throw new TaskException(TaskException.NotFoundException(taskId));
        }
    }

    //    @Override
    private void addComment(Comment comment, Task task) {
        logger.info("adding comment {} - to task {}", comment.getComment(), task.getName());
        if (task.getComments() == null) {
            List<Comment> comments = new ArrayList<>();
            comments.add(comment);
            task.setComments(comments);
        } else {
            task.getComments().add(comment);
            comment.setTask(task);
            commentRepository.save(comment);
        }
    }


    @Override
    public void updateComment(CommentRequestDTO commentRequestDTO, long id) throws CommentException {
        logger.info("updating comment with id :{}", id);
        if (commentRequestDTO == null) {
            throw new CommentException(CommentException.CommentIsNull(id));
        } else {
            Optional<Comment> commentOptional = commentRepository.findById(id);
            if (commentOptional.isPresent()) {
                Comment comment = commentOptional.get();
                comment.setComment(commentRequestDTO.getComment());
                comment.setUpdated(LocalDateTime.now());
                logger.info("comment -  {} successfully updated", comment);
                commentRepository.save(comment);
            }
        }
    }

    @Override
    public void deleteComment(CommentRequestDTO commentRequestDTO) throws CommentException {
        logger.info("remove comment :{}", commentRequestDTO.getComment());
        this.deleteComment(commentRequestDTO.getId());
    }


    //    @Override
    private void deleteComment(long id) throws CommentException {
        logger.info("searching for comment with id - {}, to delete", id);
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isEmpty()) {
            logger.warn("comment with id - {} not found", id);
            throw new CommentException(CommentException.NotFoundException(id));
        } else {
            logger.info("task with id - {} successfully deleted", id);
            commentRepository.deleteById(id);
        }
    }

}


