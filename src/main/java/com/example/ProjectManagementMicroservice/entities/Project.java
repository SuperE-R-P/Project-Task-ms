package com.example.ProjectManagementMicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Project implements Serializable{
	
		private static final long serialVersionUID = 6;
		
		@Id
		@GeneratedValue
		private int id;
		private String name ;

		private String descriptionProject;

		@CreationTimestamp
		private LocalDate createdAt;

		@UpdateTimestamp
		private LocalDate updatedAt;


		private boolean status;

	@OneToMany(mappedBy = "project")
	@JsonIgnore
	private Set<Task> tasks;

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public String getDescriptionProject() {
		return descriptionProject;
	}

	public void setDescriptionProject(String descriptionProject) {
		this.descriptionProject = descriptionProject;
	}

	public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}


	public LocalDate getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDate getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Project() {
			super();
		}
		public Project(int id, String name, String descriptionProject) {
			super();
			this.id = id;
			this.name = name;
			this.descriptionProject = descriptionProject;
		}

	@Override
	public String toString() {
		return "Project{" +
				"id=" + id +
				", name='" + name + '\'' +
				", descriptionProject='" + descriptionProject + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", status=" + status +
				", tasks=" + tasks +
				'}';
	}
}
