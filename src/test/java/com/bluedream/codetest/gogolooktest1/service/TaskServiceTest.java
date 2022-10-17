package com.bluedream.codetest.gogolooktest1.service;

import com.bluedream.codetest.gogolooktest1.model.Task;
import com.bluedream.codetest.gogolooktest1.repository.TaskRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTest {
   @Autowired
   private TaskService taskService;

   @Autowired
   private TaskRepository taskRepository;


    private Task task1 = null;
    private Task task2 = null;
/*
    @Spy
    List<Task> spiedList = new ArrayList<Task>();

    @Mock
    List<Task> mockList = new ArrayList<Task>();
*/
    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll init() method called");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("BeforeEach initEach() method called");

        task1 = new Task("Task1");
        task1.setStatus(false);

        task2 = new Task("Task2");
        task2.setStatus(false);

        taskRepository.save(task1);
        taskRepository.save(task2);
    }


    @Test
    @DisplayName("Task findAll Mock")
    //@Disabled
    void findAllTask_mock() {
        // Setup our mock repository
        task1 = new Task("Task1");
        task1.setStatus(false);

        task2 = new Task("Task2");
        task2.setStatus(false);

        /*
        spiedList.add(task1);
        spiedList.add(task2);
        doReturn(2).when(spiedList).size();
        assertEquals(2, spiedList.size());
         */

       // doReturn(Arrays.asList(task1, task2)).when(taskRepository).findAll();
        /*
        final List<String> spyList = Mockito.spy(new ArrayList<>());
        assertThatNoException().isThrownBy(() ->
                               Mockito.doReturn(100).when(spyList).size());
        assertEquals(100, spyList.size());
        */

        final List<Task> spyList2 = Mockito.spy(taskService.findAll());
        assertThatNoException().isThrownBy(() ->
                Mockito.doReturn(10).when(spyList2).size());
        assertEquals(10, spyList2.size());

    }

    @Test
    @DisplayName("Task findAll")
    void findAllTask() {

        List<Task> taskList = taskService.findAll();
        assertEquals(4, taskService.findAll().size());
    }

    @Test
    @DisplayName("Update a Task")
    void updateTask() {

        Optional<Task> optionalTask = taskService.findByID(Long.valueOf(1));
        Task task = optionalTask.get();
        assertEquals(false, task.getStatus());
        task.setStatus(true);
        taskService.save(task);
        assertEquals(true, taskService.findByID(Long.valueOf(1)).get().getStatus());
    }

    @Test
    @DisplayName("Delete a Task")
    void deleteTask() {
        assertEquals(8, taskService.findAll().size());
        taskService.deleteByID(Long.valueOf(1));

        assertEquals(7, taskService.findAll().size());
    }


}
