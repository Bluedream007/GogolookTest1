package com.bluedream.codetest.gogolooktest1.controller;


import com.bluedream.codetest.gogolooktest1.model.Task;
import com.bluedream.codetest.gogolooktest1.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by {creator's name}
 */
@RestController
//@RequestMapping("/api/v1/user")
@Api(value = "brs-application", description = "Operations pertaining to user management in the BRS application")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/tasks")
    @Operation(summary = "Get all of Task data")
    //@ApiOperation(value = {})
    public List<Task> getAllTask() {
        return (taskService.findAll());
    }

    @PostMapping(value = "/task")
    @Operation(summary = "Create a Task data")
    //@ApiOperation(value = {})
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task newTask) {

        return new ResponseEntity<Task>(taskService.save(newTask), HttpStatus.CREATED);
    }

    @PutMapping(value = "/task/{taskId}")
    @Operation(summary = "Update a Task data")
    //@ApiOperation(value = {})
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @Valid @RequestBody Task updTask) {

        Optional<Task> optionalTask = taskService.findByID(taskId);
        if (!optionalTask.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found");
        }
        /*
        Task qryTask = optionalTask.get();
        qryTask.setName(updTask.getName());
        qryTask.setStatus(updTask.getStatus());
         */
        try {
            return new ResponseEntity<Task>(taskService.save(updTask), HttpStatus.OK);
        }
        catch (Exception ex) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Provide correct data: Can't update a Task by Id: ${taskId}", ex);
            }
    }

    @DeleteMapping(value = "/task/{taskId}")
    @Operation(summary = "Delete a Task data")
    //@ApiOperation(value = {})
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {

        Optional<Task> optionalTask = taskService.findByID(taskId);
        if (!optionalTask.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found");
        } else {
            // Task qryTask = optionalTask.get();
            try {
                taskService.deleteByID(taskId);
                return new ResponseEntity(HttpStatus.OK);
            }
            catch (Exception ex) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Provide correct data: Can't delete a Task by Id: ${taskId}", ex);
            }

        }


    }

}
