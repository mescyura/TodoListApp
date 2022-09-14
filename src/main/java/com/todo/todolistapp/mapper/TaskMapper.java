package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.task.TaskDto;
import com.todo.todolistapp.dto.task.TaskResponseDto;
import com.todo.todolistapp.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskResponseDto toResponseDto(Task task);

    Task toTaskEntity(TaskDto taskDto);

    List<TaskResponseDto> toResponseDtoList(List<Task> taskList);

}
