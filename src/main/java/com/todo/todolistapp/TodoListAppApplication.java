package com.todo.todolistapp;

import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.service.ProjectServiceImpl;
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
    public CommandLineRunner demoData(ProjectServiceImpl service) {
        return args -> {

            service.saveProject(ProjectDto.builder().name("hello").description("hello").build());
            service.saveProject(ProjectDto.builder().name("yura").description("yura").build());
            service.saveProject(ProjectDto.builder().name("natalia").description("natalia").build());
            service.updateProject(ProjectDto.builder().description("yura").build(), 1L);
            service.updateProject(ProjectDto.builder().name("bye").description("bye").build(), 2L);
            service.getAllProjects();
        };
    }

}
