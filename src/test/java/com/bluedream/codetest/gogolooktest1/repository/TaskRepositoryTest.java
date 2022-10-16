package com.bluedream.codetest.gogolooktest1.repository;

import com.bluedream.codetest.gogolooktest1.model.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    private Task task1 = null;
    private Task task2 = null;


    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll init() method called");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("BeforeEach initEach() method called");
        task1 = new Task("Task1");
        task1.setStatus(false);
        entityManager.persist(task1);

        task2 = new Task("Task2");
        task2.setStatus(false);
        entityManager.persist(task2);
    }

    @Test
    @DisplayName("Find all tasks")
    public void findAllTasks() {

        List<Task> listTask = taskRepository.findAll();
        assertThat(listTask).hasSize(2).contains(task1, task2);
    }

    @Test
    @DisplayName("Find Task1 by Name")
    public void findTaskByName() {

        Task qryTask = taskRepository.findByName(task1.getName());
        assertThat(qryTask).isEqualTo(task1);
    }

    @Test
    @DisplayName("Update Task1 by Id")
    public void updateTaskById() {

        Task updTask = new Task(task1.getName());
        updTask.setStatus(true);

        Optional<Task> optionalTask = taskRepository.findById(task1.getId());
        Task qryTask1 = optionalTask.get();
        qryTask1.setStatus(updTask.getStatus());
        taskRepository.save(qryTask1);
        optionalTask = taskRepository.findById(task1.getId());
        Task ckTask1 = optionalTask.get();
        assertThat(ckTask1.getStatus()).isEqualTo(updTask.getStatus());
    }

    @Test
    @DisplayName("Delete Task1 by Id")
    public void deleteTaskById() {

        // Task delTask
        List<Task> listTask = taskRepository.findAll();
        assertThat(listTask).hasSize(2).contains(task1, task2);

        taskRepository.deleteById(task1.getId());
        listTask = taskRepository.findAll();
        assertThat(listTask).hasSize(1).contains(task2);

    }





}
