package com.brandocode.taskmanager.repo;

import com.brandocode.taskmanager.model.de.TaskDE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskDE, Long> {
    void deleteTaskById(Long id);

}
