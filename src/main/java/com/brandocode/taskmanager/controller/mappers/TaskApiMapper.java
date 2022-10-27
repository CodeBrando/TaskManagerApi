package com.brandocode.taskmanager.controller.mappers;


import com.brandocode.taskmanager.controller.to.TaskTO;
import com.brandocode.taskmanager.model.bo.TaskBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskApiMapper {

    private TaskApiMapper() throws IllegalAccessException{
        throw new IllegalAccessException("This class cannot be instantiated");
    }

    public static TaskBO convertTOToBO(TaskTO taskTO){
        return TaskBO.builder()
                .id(Objects.isNull(taskTO.getId()) ? null : taskTO.getId())
                .name(taskTO.getName())
                .done(taskTO.isDone())
                .build();
    }

    public static TaskTO convertBOToTO(TaskBO taskBO){
        return TaskTO.builder()
                .id(Objects.isNull(taskBO.getId()) ? null : taskBO.getId())
                .name(taskBO.getName())
                .done(taskBO.isDone())
                .build();
    }

    public static List<TaskTO> convertBOListToTOList(List<TaskBO> taskBOList){
        List<TaskTO> taskTOList = new ArrayList<>();
        taskBOList.forEach(taskBO -> taskTOList.add(convertBOToTO(taskBO)));
        return taskTOList;
    }

}
