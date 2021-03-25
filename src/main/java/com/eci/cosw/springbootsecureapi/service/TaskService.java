package com.eci.cosw.springbootsecureapi.service;

import java.util.List;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;

public interface TaskService {
    List<Task> geAll();

    Task getById(Long id);

    List<Task> getByUserId(Long userId);

    Task assignTaskToUser(Long taskId, User user);

    void remove(Long taskId);

    Task update(Task task);
}