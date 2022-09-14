package com.todo.todolistapp.service;

import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.dto.project.ProjectResponseDto;
import com.todo.todolistapp.exceptions.ProjectException;
import com.todo.todolistapp.entity.Project;

import java.util.List;

public interface ProjectService {
    /**
     * Save {@link Project} to DB.
     *
     * @param projectDto - entity of {@link ProjectDto}.
     * @return saved {@link ProjectResponseDto}.
     */
    ProjectResponseDto saveProject(ProjectDto projectDto) throws ProjectException;

    /**
     * Update {@link Project} in DB.
     *
     * @param id         - {@link Project} id.
     * @param projectDto - {@link ProjectDto} entity.
     * @return {@link ProjectResponseDto} updated entity.
     */
    ProjectResponseDto updateProject(ProjectDto projectDto, long id) throws ProjectException;

    /**
     * Find {@link Project} entity by id.
     *
     * @param id - {@link Project} id.
     * @return {@link ProjectResponseDto} entity.
     */
    ProjectResponseDto getProjectById(Long id) throws ProjectException;

    /**
     * Delete {@link Project} from DB by id.
     *
     * @param id - {@link Project} id.
     * @return nothing
     */
    void deleteProject(long id) throws ProjectException;

    /**
     * Find all {@link Project} from DB.
     *
     * @return List of {@link ProjectResponseDto}.
     */
    List<ProjectResponseDto> getAllProjects();
}