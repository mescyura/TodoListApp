package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.comment.CommentDto;
import com.todo.todolistapp.dto.comment.CommentResponseDto;
import com.todo.todolistapp.dto.project.ProjectDto;
import com.todo.todolistapp.dto.project.ProjectResponseDto;
import com.todo.todolistapp.entity.Comment;
import com.todo.todolistapp.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponseDto toResponseDto(Comment comment);

    Comment toCommentEntity(CommentDto commentDto);

    List<CommentResponseDto> toResponseDtoList(List<Comment> commentList);
}
