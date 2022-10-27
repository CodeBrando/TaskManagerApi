package com.brandocode.hourizer.services;

import com.brandocode.hourizer.model.bo.TaskBO;
import com.brandocode.hourizer.model.de.TaskDE;
import com.brandocode.hourizer.model.mappers.TaskMapper;
import com.brandocode.hourizer.repo.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    ITaskRepository repository;


    public void saveTask(TaskBO taskBO){
        repository.save(TaskMapper.convertBOToDE(taskBO));
    }

    public void updateTask(TaskBO taskToUpdate){
        repository.save(TaskMapper.convertBOToDE(taskToUpdate));
    }

    public List<TaskBO> findAllTasks(){
        return TaskMapper.convertTaskDEListToTaskBOList(repository.findAll());
    }

    public void deleteTask(Long id){
        repository.deleteTaskById(id);
    }
}
