package com.todo.todolistapp.service;


import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.dto.task.TaskVO;
import com.todo.todolistapp.entity.Task;

import com.todo.todolistapp.exceptions.TaskException;

import java.util.List;

public interface TaskService {

    /**
     * Save {@link Task} to DB.
     *
     * @param taskDto - entity of {@link TaskRequestDTO}.
     * @return saved {@link TaskVO}.
     */
    TaskVO saveTask(TaskRequestDTO taskDto) throws TaskException;

    /**
     * Update {@link Task} in DB.
     *
     * @param id      - {@link Task} id.
     * @param taskDto - {@link TaskRequestDTO} entity.
     * @return {@link TaskVO} updated entity.
     */
    TaskVO updateTask(TaskRequestDTO taskDto, long id) throws TaskException;

    /**
     * Find {@link Task} entity by id.
     *
     * @param id - {@link Task} id.
     * @return {@link TaskVO} entity.
     */
    TaskVO getTaskById(long id) throws TaskException;

    /**
     * Delete {@link Task} from DB by id.
     *
     * @param id - {@link Task} id.
     * @return nothing
     */
    void deleteTask(long id) throws TaskException;

    /**
     * Find all {@link Task} from DB.
     *
     * @return List of {@link TaskVO}.
     */

    List<TaskVO> getAllTasks();

}
