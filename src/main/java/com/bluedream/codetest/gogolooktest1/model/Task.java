package com.bluedream.codetest.gogolooktest1.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "t_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 20)
    private String name;

    // Value: - 0=Incomplete, - 1=Complete
    @Column(nullable = false)
    private Boolean status = false;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



}
