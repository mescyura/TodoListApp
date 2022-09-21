package com.todo.todolistapp;

import com.todo.todolistapp.dto.comment.CommentRequestDTO;
import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.enums.Priority;
import com.todo.todolistapp.service.CommentServiceImpl;
import com.todo.todolistapp.service.ProjectServiceImpl;
import com.todo.todolistapp.service.TaskServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoListAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(ProjectServiceImpl projectService, TaskServiceImpl taskService, CommentServiceImpl commentService) {
        return args -> {

            projectService.saveProject(ProjectRequestDTO.builder().name("project").description("project").build());

            projectService.getAllProjects();

            taskService.saveTask(TaskRequestDTO.builder().name("task_1").description("task_1").build());

            System.out.println(taskService.saveTask(TaskRequestDTO.builder().name("task_2").description("task_2")
                    .project(ProjectRequestDTO.builder().id(1L).name("hello").description("hello").build()).build()));
            System.out.println("----------");
            System.out.println("----------");

            System.out.println(taskService.getTaskById(2L));

            commentService.addComment(CommentRequestDTO.builder().comment("comment").build(),2L);

            commentService.addComment(CommentRequestDTO.builder().comment("comment_2").build(),2L);

            commentService.updateComment(CommentRequestDTO.builder().comment("hello").build(),1L);

            System.out.println(taskService.getTaskById(2L));

            commentService.deleteComment(CommentRequestDTO.builder().id(1L).build());

            System.out.println(taskService.getTaskById(2L));

            taskService.deleteTask(2L);

        };
    }
}
