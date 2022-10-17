package com.bluedream.codetest.gogolooktest1.controller;

import com.bluedream.codetest.gogolooktest1.model.Task;
import com.bluedream.codetest.gogolooktest1.service.TaskService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService mockTaskService;

    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll init() method called");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("BeforeEach initEach() method called");

    }

    @Test
    @DisplayName("Hello Test")
    public void getMessage() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Greetings")));
    }

    @Test
    @DisplayName("Find all Tasks")
    public void getAllTaskAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/tasks")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().string(containsString("Greetings")));

                /*
                .andExpect(MockMvcResultMatchers.jsonPath("$.task").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.task[*].name").isNotEmpty());
                 */
    }

    @Test
    public void createTaskAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/task")
                // .content(asJsonString(new EmployeeVO(null, "firstName4", "lastName4", "email4@mail.com")))
                .content("{\"name\": \"買晚餐\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.taskId").exists());
    }

}
