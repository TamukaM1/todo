package com.manjemu.springtodo.controller;

import com.manjemu.springtodo.model.Task;
import com.manjemu.springtodo.repository.TaskRepository;
import com.manjemu.springtodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks(){
        return ResponseEntity.of(Optional.ofNullable(taskService.findAllCompletedTasks()));
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllInCompleteTasks(){
        return ResponseEntity.ok(taskService.findAllUnCompletedTasks());
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task ){
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

//    public ResponseEntity<Boolean> getAllTask(@PathVariable Long id){
//        taskService.deleteTask(id);
//    }

}
