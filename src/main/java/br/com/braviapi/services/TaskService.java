package br.com.braviapi.services;

import org.springframework.data.domain.Page;

import br.com.braviapi.exceptions.NotFoundException;
import br.com.braviapi.model.TasksDTO;

public interface TaskService {

	TasksDTO createTask(TasksDTO taskDTO) throws RuntimeException;
	TasksDTO updateTask(TasksDTO tasksDTO) throws RuntimeException;
	boolean deleteTask(Long taskId) throws RuntimeException, NotFoundException;
	TasksDTO getTaskById(Long taskId) throws RuntimeException, NotFoundException;
	Page<TasksDTO> getAllTasks(int page, int size) throws RuntimeException;
	
}
