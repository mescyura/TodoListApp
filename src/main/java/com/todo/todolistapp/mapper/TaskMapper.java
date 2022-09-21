package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.task.TaskDTO;
import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.dto.task.TaskVO;
import com.todo.todolistapp.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class, CommentMapper.class, TimeMapper.class})
public interface TaskMapper {

    @Mapping(source = "dueDate", target = "dueDate", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Task toTaskEntity(TaskRequestDTO taskDto);

    @Mapping(source = "updated", target = "updated", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "dueDate", target = "dueDate", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    TaskVO toTaskVO(Task task);

    @Mapping(source = "dueDate", target = "dueDate", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "updated", target = "updated", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    TaskDTO taskToTaskDTO(Task task);

    List<TaskVO> toTaskVOList(List<Task> taskList);

}
