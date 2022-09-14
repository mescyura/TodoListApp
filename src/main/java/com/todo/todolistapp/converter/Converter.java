package com.todo.todolistapp.converter;

import com.todo.todolistapp.dto.comment.CommentDto;
import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.dto.task.TaskDto;
import com.todo.todolistapp.entity.Comment;
import com.todo.todolistapp.entity.Project;
import com.todo.todolistapp.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Converter {

    Logger logger = LoggerFactory.getLogger(Converter.class);


    //TODO deal with time conversion
    public static String dateConverter(LocalDateTime time) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String date = time.format(dateTimeFormatter);
        return date;
    }

    public TaskDto taskToTaskDto(Task task) {
        logger.debug("taskToTaskDto method. Input values:{}", task);
        TaskDto taskDto = new TaskDto();
        LocalDateTime created = task.getCreated();
        LocalDateTime dueDate = task.getDueDate();
        if (created != null) {
//            taskDto.setCreated(task.getCreated());
        }
        if (dueDate != null) {
//            taskDto.setDueDate(task.getDueDate());
        }
//        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        taskDto.setPriority(task.getPriority());
//        taskDto.setComments(parsingCommentDataToCommentDTO(task.getComments()));
//        taskDto.setProgress(task.getProgress());

        if (task.getProject() != null) {
            ProjectDto projectDTO = new ProjectDto();
//            projectDTO.setId(task.getProject().getId());
            projectDTO.setName(task.getProject().getName());
//            taskDto.setProject(projectDTO);
        }
        return taskDto;
    }

    public List<TaskDto> parsingTaskDataToTaskDTO(Collection<Task> tasks) {
        logger.debug("parsingTaskDataToTaskDTO method.");
        List<TaskDto> taskResult = new ArrayList<>();
        for (Task task : tasks) {
            TaskDto taskDto = taskToTaskDto(task);
            taskResult.add(taskDto);
        }
        return taskResult;
    }

    private CommentDto commentToCommentDto(Comment comment) {
        logger.debug("commentToCommentDto method. Input values:{}", comment);
        CommentDto commentDto = new CommentDto();
        LocalDateTime dateCreated = comment.getCreated();
        if (dateCreated != null) {
//            commentDto.setCreated(comment.getCreated());
        }
        commentDto.setId(comment.getId());
//        commentDto.setText(comment.getText());
        return commentDto;
    }

    private List<CommentDto> parsingCommentDataToCommentDTO(List<Comment> comments) {
        logger.debug("parsingCommentDataToCommentDTO method.");
        List<CommentDto> commentResult = new ArrayList<>();

        for (Comment comment : comments) {
            CommentDto commentDto = commentToCommentDto(comment);
            commentResult.add(commentDto);
        }
        return commentResult;
    }

    public ProjectDto projectToProjectDto(Project project) {
        logger.debug("converting project to project DTO", project);
        ProjectDto projectDto = new ProjectDto();
//        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        return projectDto;
    }

    public List<ProjectDto> parsingProjectDataToProjectDTO(List<Project> projects) {
        logger.debug("parsing ProjectData to Project DTO");
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projects) {
            ProjectDto projectDto = projectToProjectDto(project);
            projectDtoList.add(projectDto);
        }
        return projectDtoList;
    }
}
