package com.eci.cosw.springbootsecureapi.service.impl;

import java.util.List;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.persistence.impl.TaskPersistenceImpl;
import com.eci.cosw.springbootsecureapi.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskPersistenceImpl taskPersistenceImpl;

    @Override
    public List<Task> geAll() {
        return taskPersistenceImpl.geAll();
    }

    @Override
    public Task getById(Long id) {
        return taskPersistenceImpl.getById(id);
    }

    @Override
    public List<Task> getByUserId(Long userId) {
        return taskPersistenceImpl.getByUserId(userId);
    }

    @Override
    public Task assignTaskToUser(Long taskId, User user) {
        return taskPersistenceImpl.assignTaskToUser(taskId, user);
    }

    @Override
    public void remove(Long taskId) {
        taskPersistenceImpl.remove(taskId);

    }

    @Override
    public Task update(Task task) {
        return taskPersistenceImpl.update(task);
    }

}