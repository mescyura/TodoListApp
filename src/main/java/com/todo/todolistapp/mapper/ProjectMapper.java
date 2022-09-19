package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.project.ProjectDTO;
import com.todo.todolistapp.dto.project.ProjectVO;
import com.todo.todolistapp.entity.Project;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toProjectEntity(ProjectRequestDTO projectDto);

    ProjectVO toProjectVO(Project project);

    List<ProjectVO> toProjectVOList(List<Project> projectList);


}
