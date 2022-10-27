package com.brandocode.taskmanager.model.mappers;

import com.brandocode.taskmanager.model.bo.TaskBO;
import com.brandocode.taskmanager.model.de.TaskDE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskMapper {

    private TaskMapper() throws IllegalAccessException{
        throw new IllegalAccessException("This class cannot be instantiated");
    }

    public static TaskDE convertBOToDE(TaskBO taskBO){
        return TaskDE.builder()
                .id(Objects.isNull(taskBO.getId()) ? null : taskBO.getId())
                .name(taskBO.getName())
                .done(taskBO.isDone())
                .build();
    }

    public static TaskBO convertDEToBO(TaskDE taskDE){
        return TaskBO.builder()
                .id(Objects.isNull(taskDE.getId()) ? null : taskDE.getId())
                .name(taskDE.getName())
                .done(taskDE.isDone())
                .build();
    }

    public static List<TaskBO> convertTaskDEListToTaskBOList(List<TaskDE> taskDEList){
        List<TaskBO> taskBOList = new ArrayList<>();
        taskDEList.forEach(taskDE -> taskBOList.add(convertDEToBO(taskDE)));
        return taskBOList;
    }
}
