package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Module.Task;
import com.example.demo.Module.User;

import com.example.demo.service.TodoService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{userId}")
    public List<Task> getTasks(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return todoService.getTasks(user);
    }

    @PostMapping("/{userId}")
    public Task addTask(@PathVariable Long userId, @RequestBody Task task) {
        User user = new User();
        user.setId(userId);
        task.setUser(user);
        return todoService.addTask(user, task);
    }

    @PutMapping
    public void updateTask(@RequestBody Task task) {
        todoService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        todoService.deleteTask(id);
    }
}
