package com.todo.todolistapp.service;

import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.project.ProjectVO;
import com.todo.todolistapp.entity.Project;
import com.todo.todolistapp.exceptions.ProjectException;
import com.todo.todolistapp.mapper.ProjectMapper;
import com.todo.todolistapp.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectMapper mapper;
    private final ProjectRepository repository;

    @Autowired
    public ProjectServiceImpl(ProjectMapper mapper, ProjectRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ProjectVO saveProject(ProjectRequestDTO projectDto) throws ProjectException {
        Optional<Project> optionalProject = repository.findProjectByName(projectDto.getName());
        if ((optionalProject.isPresent())) {
            logger.warn("there is an existing project with {} name already", projectDto.getName());
            throw new ProjectException(ProjectException.ProjectAlreadyExists());
        }
        Project project = mapper.toProjectEntity(projectDto);
        project.setCreated(LocalDateTime.now());
        Project savedProject = repository.save(project);
        logger.info("project -  {} successfully created", project);
        return mapper.toProjectVO(savedProject);
    }

    @Override
    public ProjectVO updateProject(ProjectRequestDTO projectDto, long id) throws ProjectException {
        logger.info("searching for a project with id - {}, to update", id);
        Optional<Project> projectOptional = repository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setName(projectDto.getName());
            project.setDescription(projectDto.getDescription());
            project.setUpdated(LocalDateTime.now());
            Project savedProject = repository.save(project);
            logger.info("project -  {} successfully updated", project);
            return mapper.toProjectVO(savedProject);
        } else {
            logger.warn("project with id - {} not found", id);
            throw new ProjectException(ProjectException.NotFoundException(id));
        }
    }

    @Override
    public ProjectVO getProjectById(Long id) throws ProjectException {
        logger.info("searching for a project with id - {}", id);
        Optional<Project> projectOptional = repository.findById(id);
        if (projectOptional.isPresent()) {
            projectOptional.get().getTaskList().iterator();
            logger.info("found project - {}", projectOptional.get());
            return mapper.toProjectVO(projectOptional.get());
        } else {
            logger.warn("project with id - {} not found", id);
            throw new ProjectException(ProjectException.NotFoundException(id));
        }
    }

    @Override
    public void deleteProject(long id) throws ProjectException {
        logger.info("searching for project with id - {}, to delete", id);
        Optional<Project> optionalProject = repository.findById(id);
        if (optionalProject.isEmpty()) {
            logger.warn("project with id - {} not found", id);
            throw new ProjectException(ProjectException.NotFoundException(id));
        } else {
            logger.info("project with id - {} successfully deleted", id);
            repository.deleteById(id);
        }
    }

    @Override
    public List<ProjectVO> getAllProjects() {
        logger.info("getting all projects");
        List<Project> projects = repository.findAll();
        if (projects.size() > 0) {
            logger.info("successfully loaded projects {} ", projects);
            return mapper.toProjectVOList(projects);
        } else {
            logger.warn("no projects in the database");
            return new ArrayList<>();
        }
    }
}