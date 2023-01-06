package com.student_list.student_list.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiException {
    private final int status;
    private final Object message;
    private final LocalDateTime date;
}
