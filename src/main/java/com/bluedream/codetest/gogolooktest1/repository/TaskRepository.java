package com.bluedream.codetest.gogolooktest1.repository;

import com.bluedream.codetest.gogolooktest1.model.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // List<Task> findAllBy();

    public Task findByName(String name);


    List<Task> findAll();


}