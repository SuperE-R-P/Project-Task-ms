package com.example.ProjectManagementMicroservice.repository;

import java.util.List;

import com.example.ProjectManagementMicroservice.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	//Requete de recherche d'un projet par son nom
	//http://localhost:8181/project/search/projectByName?name=projet1
	@Query("select c from Project c where c.name like :name")
	public Page<Project> projectByName(@Param("name") String n, Pageable pageable);
	
	List<Project> findByName(String name);
}
