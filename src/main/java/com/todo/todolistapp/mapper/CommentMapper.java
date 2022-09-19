package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.comment.CommentDto;
import com.todo.todolistapp.dto.comment.CommentResponseDto;
import com.todo.todolistapp.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentResponseDto toResponseDto(Comment comment);

    Comment toCommentEntity(CommentDto commentDto);

    List<CommentResponseDto> toResponseDtoList(List<Comment> commentList);
}
