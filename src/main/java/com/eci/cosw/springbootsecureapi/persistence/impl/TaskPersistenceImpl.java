package com.eci.cosw.springbootsecureapi.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.persistence.TaskPersistence;

import org.springframework.stereotype.Service;

@Service
public class TaskPersistenceImpl implements TaskPersistence {

    private ConcurrentHashMap<Long, Task> taskMap = new ConcurrentHashMap<>();

    @Override
    public List<Task> geAll() {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskMap.values());
        return tasks;
    }

    @Override
    public Task getById(Long id) {
        return taskMap.get(id);
    }

    @Override
    public List<Task> getByUserId(Long userId) {
        List<Task> tasks = new ArrayList<>();
        for (Task t : taskMap.values()) {
            if (t.getResponsible().getId() == userId) {
                tasks.add(t);
            }
        }
        return tasks;
    }

    @Override
    public Task assignTaskToUser(Long taskId, User user) {
        Task t = null;
        if (taskMap.containsKey(taskId)) {
            t = taskMap.get(taskId);
            t.setResponsible(user);
        }
        return t;
    }

    @Override
    public void remove(Long taskId) {
        taskMap.remove(taskId);

    }

    @Override
    public Task update(Task task) {
        return taskMap.replace(task.getId(), task);
    }

}