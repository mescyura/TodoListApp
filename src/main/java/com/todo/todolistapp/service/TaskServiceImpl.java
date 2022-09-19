package com.todo.todolistapp.service;

import com.todo.todolistapp.dto.task.TaskRequestDTO;
import com.todo.todolistapp.dto.task.TaskVO;
import com.todo.todolistapp.entity.Project;
import com.todo.todolistapp.entity.Task;
import com.todo.todolistapp.enums.Status;
import com.todo.todolistapp.exceptions.TaskException;
import com.todo.todolistapp.mapper.ProjectMapper;
import com.todo.todolistapp.mapper.TaskMapper;
import com.todo.todolistapp.repository.ProjectRepository;
import com.todo.todolistapp.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {


    Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    private final TaskMapper taskMapper;
    private final ProjectMapper projectMapper;

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public TaskServiceImpl(TaskMapper mapper, TaskRepository taskRepository, ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.taskMapper = mapper;
        this.projectMapper = projectMapper;
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;

    }

    @Override
    public TaskVO saveTask(TaskRequestDTO taskDto) throws TaskException {
        Optional<Task> optionalTask = taskRepository.findTaskByName(taskDto.getName());
        if ((optionalTask.isPresent())) {
            logger.warn("there is an existing task with {} name already", taskDto.getName());
            throw new TaskException(TaskException.TaskAlreadyExists());
        }
        Task task = taskMapper.toTaskEntity(taskDto);
        task.setCreated(LocalDateTime.now());
        Task savedTask = taskRepository.save(task);
        logger.info("task -  {} successfully created", taskDto);
        return taskMapper.toTaskVO(savedTask);
    }

    @Override //TODO - not working
    public TaskVO updateTask(TaskRequestDTO taskDto, long id) throws TaskException {
        logger.info("searching for a task with id - {}, to update", id);
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setName(taskDto.getName());
            task.setDescription(task.getDescription());
            if (taskDto.getDueDate() != null) {
                task.setDueDate(LocalDateTime.parse(taskDto.getDueDate()));
            }
            task.setStatus(taskDto.getStatus());
            task.setPriority(taskDto.getPriority());
            task.setUpdated(LocalDateTime.now());
            task.setProgress(taskDto.getProgress());
            if (taskDto.getProgress() >= 10 && task.getStatus() == Status.TODO) {
                task.setStatus(Status.IN_PROGRESS);
            }
            if (taskDto.getProgress() == 100) {
                if (task.getStatus() == Status.IN_PROGRESS || task.getStatus() == Status.PAUSE) {
                    task.setStatus(Status.COMPLETE);
                }
            }
            if (taskDto.getProject() != null) {
                Project project = projectRepository.findById(taskDto.getProject().getId()).get();
                project.addTask(task);
                task.setProject(project);
                projectRepository.save(project);
            }
            if(taskDto.getProject() == null){
                task.setProject(null);
            }
            Task savedTask = taskRepository.save(task);
            logger.info("task -  {} successfully updated", taskDto);
            return taskMapper.toTaskVO(savedTask);
        } else {
            logger.warn("task with id - {} not found", id);
            throw new TaskException(TaskException.NotFoundException(id));
        }
    }

    @Override
    public TaskVO getTaskById(long id) throws TaskException {
        logger.info("searching for a task with id - {}", id);
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            logger.info("found task - {}", taskOptional.get());
            return taskMapper.toTaskVO(taskOptional.get());
        } else {
            logger.warn("task with id - {} not found", id);
            throw new TaskException(TaskException.NotFoundException(id));
        }
    }

    @Override
    public void deleteTask(long id) throws TaskException {
        logger.info("searching for task with id - {}, to delete", id);
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            logger.warn("task with id - {} not found", id);
            throw new TaskException(TaskException.NotFoundException(id));
        } else {
            logger.info("task with id - {} successfully deleted", id);
            taskRepository.deleteById(id);
        }
    }

    @Override
    public List<TaskVO> getAllTasks() {
        logger.info("getting all tasks");
        List<Task> tasks = taskRepository.findAll();
        if (tasks.size() > 0) {
            logger.info("successfully loaded tasks {} ", tasks);
            return taskMapper.toTaskVOList(tasks);
        } else {
            logger.warn("no tasks in the database");
            return new ArrayList<>();
        }
    }
}
