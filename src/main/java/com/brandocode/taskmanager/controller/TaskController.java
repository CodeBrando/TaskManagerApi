package com.brandocode.taskmanager.controller;

import com.brandocode.taskmanager.controller.mappers.TaskApiMapper;
import com.brandocode.taskmanager.controller.to.ResponseTO;
import com.brandocode.taskmanager.controller.to.TaskTO;
import com.brandocode.taskmanager.services.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@Log4j2
public class TaskController implements ITaskController{

    @Autowired
    TaskService taskService;

    @Override
    public ResponseEntity<ResponseTO> createTask(TaskTO taskTO){
        log.info("STARTING TO SAVE TASK...");
        ResponseEntity<ResponseTO> response;
        try{
            taskService.saveTask(TaskApiMapper.convertTOToBO(taskTO));
            response = new ResponseEntity<>(ResponseTO.builder().message(HttpStatus.CREATED.name()).build(), HttpStatus.CREATED);
            log.info("TASK CREATED SUCCESSFULLY");
        } catch(EntityExistsException e){
            log.error("THERE HAS BEEN AN ERROR WHILE CREATING THE TASK." + e);
            response = new ResponseEntity<>(ResponseTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Override
    public ResponseEntity<ResponseTO> updateTask(TaskTO taskTO){
        log.info("STARTING TO UPDATE TASK...");
        ResponseEntity<ResponseTO> response;
        try{
            taskService.updateTask(TaskApiMapper.convertTOToBO(taskTO));
            response = new ResponseEntity<>(ResponseTO.builder().message(HttpStatus.OK.name()).build(), HttpStatus.OK);
            log.info("TASK SUCCESSFULLY UPDATED");
        } catch (EntityNotFoundException | EntityExistsException e){
            log.error("THERE HAS BEEN AN ERROR WHILE UPDATING THE TASK" + e);
            response = new ResponseEntity<>(ResponseTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Override
    public ResponseEntity<?> getTasks(){
        log.info("STARTING TO FIND ALL TASKS...");
        ResponseEntity<?> response;
        try{
            List<TaskTO> taskTOList = TaskApiMapper.convertBOListToTOList(taskService.findAllTasks());
            response = new ResponseEntity<>(taskTOList, HttpStatus.OK);
        } catch(EntityNotFoundException e){
            log.info("THERE HAS BEEN AN ERROR WHILE FINDING ALL TASKS");
            response = new ResponseEntity<>(ResponseTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Override
    public ResponseEntity<?> deleteTask(Long id){
        log.info("STARTING TO DELETE TASK...");
        ResponseEntity<?> response;
        try {
            taskService.deleteTask(id);
            response = new ResponseEntity<>(ResponseTO.builder().message(HttpStatus.OK.name()).build(), HttpStatus.OK);
            log.info("TASK SUCCESSFULLY DELETED");
        } catch(EntityNotFoundException e){
            log.info("THERE HAS BEEN AN ERROR WHILE DELETING THE TASK" + e);
            response = new ResponseEntity<>(ResponseTO.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }


}
