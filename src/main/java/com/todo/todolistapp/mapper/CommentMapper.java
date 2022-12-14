package com.todo.todolistapp.mapper;

import com.todo.todolistapp.dto.comment.CommentDTO;
import com.todo.todolistapp.dto.comment.CommentRequestDTO;
import com.todo.todolistapp.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = TimeMapper.class)
public interface CommentMapper {

//    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment toCommentEntity(CommentRequestDTO commentRequestDTO);

    @Mapping(source = "updated", target = "updated", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    CommentDTO toCommentDTO(Comment comment);

    List<CommentDTO> toCommentDTOList(List<Comment> commentList);
}
