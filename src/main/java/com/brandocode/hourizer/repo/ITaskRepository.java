package com.brandocode.hourizer.repo;

import com.brandocode.hourizer.model.de.TaskDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface ITaskRepository extends JpaRepository<TaskDE, Long> {
    void deleteTaskById(Long id);

}
