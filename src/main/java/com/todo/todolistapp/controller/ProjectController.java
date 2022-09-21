package com.todo.todolistapp.controller;

import com.todo.todolistapp.dto.project.ProjectDTO;
import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.project.ProjectVO;
import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.dto.task.TaskVO;
import com.todo.todolistapp.exceptions.ProjectException;
import com.todo.todolistapp.exceptions.TaskException;
import com.todo.todolistapp.service.ProjectService;
import com.todo.todolistapp.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/proj")
public class ProjectController {

    @Autowired
    ProjectService service;

    @Autowired
    TaskService taskService;

    @GetMapping("/all-projects")
    public ResponseEntity<List<?>> getAllProjects() {
        log.info("getting all projects controller");
        List<ProjectVO> projects = service.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);

    }
  //TODO - delete from here

    @GetMapping("/all-tasks")
    public ResponseEntity<List<?>> getAllTasks() {
        log.info("getting all projects controller");
        List<TaskVO> users = taskService.getAllTasks();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping(value = "/create-task", consumes = "application/json")
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO) {
        log.info("create a task controller");
        try {
            taskService.saveTask(taskRequestDTO);
            return new ResponseEntity<>(taskRequestDTO, HttpStatus.OK);
        } catch (TaskException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/create-project", consumes = "application/json")
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectRequestDTO projectDto) {
        log.info("create a project controller");
        try {
            service.saveProject(projectDto);
            return new ResponseEntity<>(projectDto, HttpStatus.OK);
        } catch (ProjectException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/update-project/{id}", consumes = "application/json")
    public ResponseEntity<?> updateProject(@Valid @RequestBody ProjectRequestDTO projectDto, @PathVariable long id) {
        log.info("update project controller");
        try {
            service.updateProject(projectDto, id);
            return new ResponseEntity<>(projectDto, HttpStatus.OK);
        } catch (ProjectException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable("id") long id) {
        log.info("get project by id {} controller", id);
        try {
            return new ResponseEntity<>(service.getProjectById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity<?> deleteProjectById(@PathVariable("id") long id) {
        log.info("delete project by id {} controller", id);
        try {
            service.deleteProject(id);
            return new ResponseEntity<>("Successfully deleted project by id - " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
