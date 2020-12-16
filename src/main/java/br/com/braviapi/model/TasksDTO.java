package br.com.braviapi.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.braviapi.validations.OnUpdate;


public class TasksDTO implements Serializable {

	private static final long serialVersionUID = 4340087392646496489L;	
	
	@NotNull(groups = {OnUpdate.class})
	private Long id;
	@NotNull
	private LocalDate initialDate;
	@NotNull
	private LocalDate finalDate;
	@NotNull(groups = {OnUpdate.class})
	private TaskStatusEnum status;
	@NotNull
	private String title;
	private String description;
	private String taskSpendTime;
	
	public TasksDTO(@NotNull(groups = OnUpdate.class) Long id, @NotNull LocalDate initialDate,
					@NotNull LocalDate finalDate, @NotNull(groups = OnUpdate.class) TaskStatusEnum status, String title,
					String description, String taskSpendTime) {
		super();
		this.id = id;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.status = status;
		this.title = title;
		this.description = description;
		this.taskSpendTime = taskSpendTime;
	}

	public TasksDTO() {
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

	public String getTaskSpendTime() {
		return taskSpendTime;
	}

	public void setTaskSpendTime(String taskSpendTime) {
		this.taskSpendTime = taskSpendTime;
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
		TasksDTO other = (TasksDTO) obj;
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
		return "TasksDTO [id=" + id + ", initialDate=" + initialDate + ", finalDate=" + finalDate + ", status=" + status
				+ ", title=" + title + ", description=" + description + ", taskSpendTime=" + taskSpendTime + "]";
	}
}
