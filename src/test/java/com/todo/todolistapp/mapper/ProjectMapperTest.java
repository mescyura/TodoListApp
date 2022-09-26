package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.project.ProjectDTO;
import com.todo.todolistapp.dto.project.ProjectRequestDTO;
import com.todo.todolistapp.dto.project.ProjectVO;
import com.todo.todolistapp.entity.Project;
import com.todo.todolistapp.entity.Task;
import com.todo.todolistapp.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProjectMapperTest {

    @Autowired
    private ProjectMapper projectMapperTest;

    @Autowired
    private TimeMapper timeMapper;


    @Test
    void toProjectEntity() {
        //given
        ProjectRequestDTO requestDTOExp = ProjectRequestDTO.builder()
                .name("test-project").description("test-project-description").build();
        //when
        Project projectAct = projectMapperTest.toProjectEntity(requestDTOExp);
        //then
        Assertions.assertNotNull(projectAct);
        Assertions.assertEquals(requestDTOExp.getName(), projectAct.getName());
        Assertions.assertEquals(requestDTOExp.getDescription(), projectAct.getDescription());
    }

    @Test
    void toProjectEntityWithOfDescription() {
        //given
        ProjectRequestDTO requestDTOExp = ProjectRequestDTO.builder().name("test-project-no-description").build();
        //when
        Project projectAct = projectMapperTest.toProjectEntity(requestDTOExp);
        //then
        Assertions.assertNotNull(projectAct);
        Assertions.assertEquals(requestDTOExp.getName(), projectAct.getName());
        Assertions.assertNull(projectAct.getDescription());
    }

    @Test
    void toProjectVO() {
        //given
        Project projectExp = Project.builder().id(2L).
                name("text")
                .description("text1")
                .created(LocalDateTime.now()).build();

        List<Task> taskList = List.of(Task.builder().id(1L).name("text").description("text").status(Status.TODO)
                        .created(LocalDateTime.now())
                        .project(projectExp).build(),
                Task.builder().id(2L).name("text_2").description("text_2").status(Status.PAUSE)
                        .created(LocalDateTime.now())
                        .project(projectExp).build());

        projectExp.setTaskList(taskList);
        //when
        ProjectVO projectVOtAct = projectMapperTest.toProjectVO(projectExp);
        //then
        Assertions.assertNotNull(projectVOtAct);
        Assertions.assertEquals(projectExp.getName(), projectVOtAct.getName());
        Assertions.assertEquals(projectExp.getDescription(), projectVOtAct.getDescription());
        Assertions.assertEquals(timeMapper.asString(projectExp.getCreated()), projectVOtAct.getCreated());
        Assertions.assertEquals(projectExp.getTaskList().size(), projectVOtAct.getTaskList().size());
    }

    @Test
    void projectToProjectDTO() {
        //given
        Project projectExp = Project.builder().id(2L).
                name("text")
                .description("text1")
                .created(LocalDateTime.now().minusDays(4).minusHours(5))
                .updated(LocalDateTime.now()).build();
        //when
        ProjectDTO projectDTOtAct = projectMapperTest.projectToProjectDTO(projectExp);
        //then
        Assertions.assertNotNull(projectDTOtAct);
        Assertions.assertEquals(projectExp.getId(), projectDTOtAct.getId());
        Assertions.assertEquals(projectExp.getName(), projectDTOtAct.getName());
        Assertions.assertEquals(projectExp.getDescription(), projectDTOtAct.getDescription());
        Assertions.assertEquals(timeMapper.asString(projectExp.getCreated()), projectDTOtAct.getCreated());
        Assertions.assertEquals(timeMapper.asString(projectExp.getUpdated()), projectDTOtAct.getUpdated());
    }

    @Test
    void toProjectVOList() {
        //given
        Project project1 = Project.builder().id(2L).
                name("text")
                .description("text1")
                .created(LocalDateTime.now()).build();

        List<Task> taskList1 = List.of(Task.builder().id(1L).name("text").description("text").status(Status.TODO)
                        .created(LocalDateTime.now())
                        .project(project1).build(),
                Task.builder().id(2L).name("text_2").description("text_2").status(Status.PAUSE)
                        .created(LocalDateTime.now())
                        .project(project1).build());

        project1.setTaskList(taskList1);

        Project project2 = Project.builder().id(6L).
                name("text2")
                .description("text_2")
                .created(LocalDateTime.now()).build();

        List<Task> taskList2 = List.of(Task.builder().id(5L).name("text_tesst").description("text-test").status(Status.TODO)
                        .created(LocalDateTime.now())
                        .project(project2).build(),
                Task.builder().id(3L).name("text_3").description("text_22").status(Status.IN_PROGRESS)
                        .created(LocalDateTime.now())
                        .project(project2).build());

        project2.setTaskList(taskList2);
        ///
        List<Project> projectListExp = List.of(project1, project2);
        //when

        List<ProjectVO> projectVOSAct = projectMapperTest.toProjectVOList(projectListExp);
        //then
        Assertions.assertNotNull(projectVOSAct);
        Assertions.assertEquals(2, projectVOSAct.size());
        Assertions.assertEquals(project1.getId(), projectVOSAct.get(0).getId());
        Assertions.assertEquals(project1.getName(), projectVOSAct.get(0).getName());
        Assertions.assertEquals(project2.getId(), projectVOSAct.get(1).getId());
        Assertions.assertEquals(project2.getName(), projectVOSAct.get(1).getName());
    }
}