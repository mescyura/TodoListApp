package com.todo.todolistapp.repository;

import com.todo.todolistapp.entity.Project;
import com.todo.todolistapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findProjectByName(String projectName);

}