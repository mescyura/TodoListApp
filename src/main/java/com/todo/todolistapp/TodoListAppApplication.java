package com.todo.todolistapp;

import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.enums.Priority;
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
    public CommandLineRunner demoData(ProjectServiceImpl projectService, TaskServiceImpl taskService) {
        return args -> {

            projectService.saveProject(ProjectRequestDTO.builder().name("project").description("project").build());

            projectService.saveProject(ProjectRequestDTO.builder().name("project_2").description("project_2").build());

            projectService.saveProject(ProjectRequestDTO.builder().name("project_3").description("project_3").build());


            projectService.getAllProjects();

            taskService.saveTask(TaskRequestDTO.builder().name("task_1").description("task_1").build());

            taskService.saveTask(TaskRequestDTO.builder().name("task_2").description("task_2")
                    .project(ProjectRequestDTO.builder().id(1L).name("hello").description("hello").build()).build());

            taskService.saveTask(TaskRequestDTO.builder().name("task_3").description("task_3")
                    .project(ProjectRequestDTO.builder().id(1L).name("hello").description("hello").build()).build());

            taskService.saveTask(TaskRequestDTO.builder().name("task_4").description("task_4")
                    .project(ProjectRequestDTO.builder().id(1L).name("hello").description("hello").build()).build());

            projectService.getProjectById(1L);

            taskService.getAllTasks();

            taskService.updateTask(TaskRequestDTO.builder().name("updated task_1").priority(Priority.HIGH)
                    .project(ProjectRequestDTO.builder().id(1L).name("project").description("project").build()).build(), 1L);

            projectService.getAllProjects();

            taskService.updateTask(TaskRequestDTO.builder().name("updated task_1").priority(Priority.LOW).build(), 4L);

          projectService.getAllProjects();
          taskService.getAllTasks();

        };
    }

}
