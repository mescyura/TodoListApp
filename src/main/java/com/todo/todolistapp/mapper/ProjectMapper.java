package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.dto.project.ProjectResponseDto;
import com.todo.todolistapp.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectResponseDto toResponseDto(Project project);

    Project toProjectEntity(ProjectDto projectDto);

    List<ProjectResponseDto> toResponseDtoList(List<Project> projectList);


}
