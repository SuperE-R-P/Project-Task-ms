package com.example.ProjectManagementMicroservice.repository;

import com.example.ProjectManagementMicroservice.entities.Project;
import com.example.ProjectManagementMicroservice.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select c from Task c where c.name like :name")
    public Page<Task> taskByName(@Param("name") String n, Pageable pageable);

    List<Task> findByName(String name);
}
