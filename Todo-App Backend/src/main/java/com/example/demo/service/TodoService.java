package com.example.demo.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Module.Task;
import com.example.demo.Module.User;
import com.example.demo.repository.TaskRepository;

@Service
public class TodoService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks(User user) {
        return taskRepository.findByUserId(user.getId());
    }

    public Task addTask(User user, Task task) {
        task.setUser(user);
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }
}



