package com.brandocode.taskmanager.model.bo;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class TaskBO {
    private Long id;
    private String name;
    private boolean done;

}
