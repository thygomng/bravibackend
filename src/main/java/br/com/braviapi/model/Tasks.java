package br.com.braviapi.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tasks")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tasks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949159030534754666L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;
	
	@NotNull
	@Column(name = "initial_date")
	private LocalDate initialDate;
	
	@NotNull
	@Column(name = "final_date")
	private LocalDate finalDate;
	
	@Column(name = "task_spend_time")
	private String taskSpendTime;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private TaskStatusEnum status;
	
	@NotNull
	@Column(name = "title", length = 200)
	private String title;
	
	@Column(name = "description", length = 2000)
	private String description;

	public Tasks(Long id, LocalDate initialDate, LocalDate finalDate, String taskSpendTime, TaskStatusEnum status,
			String title, String description) {
		super();
		this.id = id;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.taskSpendTime = taskSpendTime;
		this.status = status;
		this.title = title;
		this.description = description;
	}

	public Tasks() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	public String getTaskSpendTime() {
		return taskSpendTime;
	}

	public void setTaskSpendTime(String taskSpendTime) {
		this.taskSpendTime = taskSpendTime;
	}

	public TaskStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TaskStatusEnum status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((finalDate == null) ? 0 : finalDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((initialDate == null) ? 0 : initialDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taskSpendTime == null) ? 0 : taskSpendTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (finalDate == null) {
			if (other.finalDate != null)
				return false;
		} else if (!finalDate.equals(other.finalDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initialDate == null) {
			if (other.initialDate != null)
				return false;
		} else if (!initialDate.equals(other.initialDate))
			return false;
		if (status != other.status)
			return false;
		if (taskSpendTime == null) {
			if (other.taskSpendTime != null)
				return false;
		} else if (!taskSpendTime.equals(other.taskSpendTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", initialDate=" + initialDate + ", finalDate=" + finalDate + ", taskSpendTime="
				+ taskSpendTime + ", status=" + status + ", title=" + title + ", description=" + description + "]";
	}
}
