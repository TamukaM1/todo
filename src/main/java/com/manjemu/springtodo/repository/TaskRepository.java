package com.manjemu.springtodo.repository;

import com.manjemu.springtodo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
//    public Task findByTask(String task);
    public List<Task> findByIsCompletedTrue();
    public List<Task> findByIsCompletedFalse();
    public List<Task> findAll();
    public Task getById(Long id);

}
