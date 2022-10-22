package com.example.ProjectManagementMicroservice.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Project implements Serializable{
	
		private static final long serialVersionUID = 6;
		
		@Id
		@GeneratedValue
		private int id;
		private String name ;
		@Lob
		private String description;

		@CreationTimestamp
		private LocalDate createdAt;

		@UpdateTimestamp
		private LocalDate updatedAt;


		private boolean status;



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
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String name) {
			this.description = description;
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
		public Project(int id, String name, String description) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
		}
		@Override
		public String toString() {
			return "Project [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", created at=" + createdAt+ "]";
		}


}
