package com.todo.todolistapp.converter;

import com.todo.todolistapp.dto.comment.CommentDto;
import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.task.TaskRequestDTO;
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

    public TaskRequestDTO taskToTaskDto(Task task) {
        logger.debug("taskToTaskDto method. Input values:{}", task);
        TaskRequestDTO taskDto = new TaskRequestDTO();
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
            ProjectRequestDTO projectDTO = new ProjectRequestDTO();
//            projectDTO.setId(task.getProject().getId());
            projectDTO.setName(task.getProject().getName());
//            taskDto.setProject(projectDTO);
        }
        return taskDto;
    }

    public List<TaskRequestDTO> parsingTaskDataToTaskDTO(Collection<Task> tasks) {
        logger.debug("parsingTaskDataToTaskDTO method.");
        List<TaskRequestDTO> taskResult = new ArrayList<>();
        for (Task task : tasks) {
            TaskRequestDTO taskDto = taskToTaskDto(task);
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

    public ProjectRequestDTO projectToProjectDto(Project project) {
        logger.debug("converting project to project DTO", project);
        ProjectRequestDTO projectDto = new ProjectRequestDTO();
//        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        return projectDto;
    }

    public List<ProjectRequestDTO> parsingProjectDataToProjectDTO(List<Project> projects) {
        logger.debug("parsing ProjectData to Project DTO");
        List<ProjectRequestDTO> projectDtoList = new ArrayList<>();
        for (Project project : projects) {
            ProjectRequestDTO projectDto = projectToProjectDto(project);
            projectDtoList.add(projectDto);
        }
        return projectDtoList;
    }
}
