package com.student_list.student_list.controllers.Request;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStudent {

    @NotBlank
    @NotNull
    String name;

    @NotNull
    Integer age =0;
}
