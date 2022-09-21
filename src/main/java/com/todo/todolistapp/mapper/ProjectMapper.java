package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.project.ProjectDTO;
import com.todo.todolistapp.dto.project.ProjectVO;
import com.todo.todolistapp.entity.Project;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskMapper.class, TimeMapper.class})
public interface ProjectMapper {

    Project toProjectEntity(ProjectRequestDTO projectDto);

    @Mapping(source = "updated", target = "updated", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    ProjectVO toProjectVO(Project project);

    @Mapping(source = "updated", target = "updated", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    ProjectDTO projectToProjectDTO(Project project);

    List<ProjectVO> toProjectVOList(List<Project> projectList);


}
