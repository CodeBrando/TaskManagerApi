package com.brandocode.hourizer.controller.to;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class TaskTO {

    private Long id;

    @NotNull(message = "Name value is required")
    @Size(min = 1, max = 100)
    private String name;

    private boolean done;
}
