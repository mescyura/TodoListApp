package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.dto.task.TaskVO;
import com.todo.todolistapp.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toTaskEntity(TaskRequestDTO taskDto);

    TaskVO toTaskVO(Task task);

    List<TaskVO> toTaskVOList(List<Task> taskList);

}
