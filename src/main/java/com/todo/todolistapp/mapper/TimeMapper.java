package com.todo.todolistapp.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeMapper {

//    TimeMapper INSTANCE = Mappers.getMapper(TimeMapper.class);

    public String asString(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String date = localDateTime.format(dateTimeFormatter);
        return localDateTime != null ? date : null;
    }

    public LocalDateTime asLocalDateTime(String date) {
        return date != null ? LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null;
    }
}
