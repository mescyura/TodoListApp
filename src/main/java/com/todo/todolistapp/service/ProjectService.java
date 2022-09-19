package com.todo.todolistapp.service;

import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.project.ProjectDTO;
import com.todo.todolistapp.dto.project.ProjectVO;
import com.todo.todolistapp.exceptions.ProjectException;
import com.todo.todolistapp.entity.Project;

import java.util.List;

public interface ProjectService {
    /**
     * Save {@link Project} to DB.
     *
     * @param projectDto - entity of {@link ProjectRequestDTO}.
     * @return saved {@link ProjectDTO}.
     */
    ProjectVO saveProject(ProjectRequestDTO projectDto) throws ProjectException;

    /**
     * Update {@link Project} in DB.
     *
     * @param id         - {@link Project} id.
     * @param projectDto - {@link ProjectRequestDTO} entity.
     * @return {@link ProjectDTO} updated entity.
     */
    ProjectVO updateProject(ProjectRequestDTO projectDto, long id) throws ProjectException;

    /**
     * Find {@link Project} entity by id.
     *
     * @param id - {@link Project} id.
     * @return {@link ProjectDTO} entity.
     */
    ProjectVO getProjectById(Long id) throws ProjectException;

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
     * @return List of {@link ProjectDTO}.
     */
    List<ProjectVO> getAllProjects();
}