package com.todo.todolistapp.controller;

import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.dto.project.ProjectResponseDto;
import com.todo.todolistapp.exceptions.ProjectException;
import com.todo.todolistapp.service.ProjectService;
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

    @GetMapping("/all-projects")
    public ResponseEntity<List<?>> getAllProjects() {
        log.info("getting all projects controller");
        List<ProjectResponseDto> users = service.getAllProjects();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping(value = "/create-project", consumes = "application/json")
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectDto projectDto) {
        log.info("create a project controller");
        try {
            service.saveProject(projectDto);
            return new ResponseEntity<>(projectDto, HttpStatus.OK);
        } catch (ProjectException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/update-project/{id}", consumes = "application/json")
    public ResponseEntity<?> updateProject(@Valid @RequestBody ProjectDto projectDto, @PathVariable long id) {
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
