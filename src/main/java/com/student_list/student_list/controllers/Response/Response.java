package com.student_list.student_list.controllers.Response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Response {
    private final int status;
    private final String message;
    private final Object result;
    private final LocalDateTime date;
}