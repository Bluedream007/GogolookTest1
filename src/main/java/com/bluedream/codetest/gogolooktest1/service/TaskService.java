package com.bluedream.codetest.gogolooktest1.service;


import com.bluedream.codetest.gogolooktest1.model.Task;
import com.bluedream.codetest.gogolooktest1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Created by {creator's name}
 */
@Service
public class TaskService {

    //@Autowired
    //private RoleRepository roleRepository;

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Fetch all of user data in the database     *
     *
     * @return
     */
    public List<Task> findAll() {
        List<Task> taskList = taskRepository.findAll();
        return taskList;
    }

    public Task save(Task newTask) {
        return taskRepository.save(newTask);
    }

    public Optional<Task> findByID(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);

        return optionalTask;
    }

    public void deleteByID(Long taskId) {

        taskRepository.deleteById(taskId);
    }
}
