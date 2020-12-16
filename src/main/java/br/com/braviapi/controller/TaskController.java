package br.com.braviapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.braviapi.model.TasksDTO;
import br.com.braviapi.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	 private final Logger log = LoggerFactory.getLogger(TaskController.class);
	 
	 private TaskService taskService;
	 
	 public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TasksDTO> createTask(@Validated @RequestBody TasksDTO taskDTO) throws URISyntaxException {
		try {
			TasksDTO response = this.taskService.createTask(taskDTO);
			
			log.info("Task Created => " + response.getId());
			return ResponseEntity.created(new URI("/api/tasks/" + response.getId())).body(response);
		} catch (RuntimeException e) {
			log.error("Unexpected error while create task", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TasksDTO> updateTask(@Validated  @RequestBody TasksDTO taskDTO) {
		try {
			TasksDTO response = this.taskService.updateTask(taskDTO);
			
			log.info("Task Updated => " + response.getId());
			return ResponseEntity.ok().body(response);
		} catch (RuntimeException e) {
			log.error("Unexpected error while update task", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} 
	}
	
	@DeleteMapping(name = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
		try {
			Boolean response = this.taskService.deleteTask(id);
			
			log.info("Task Finded => " + id);
			return ResponseEntity.ok().body(response);
		} catch (RuntimeException e) {
			log.error("Unexpected error while finded task", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}  
	}
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TasksDTO> findTask(@PathVariable Long id) {
		try {
			TasksDTO response = this.taskService.getTaskById(id);
			
			return ResponseEntity.ok().body(response);
		} catch (RuntimeException e) {
			log.error("Unexpected error while find task", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} 
	}
	
	@GetMapping(value = "gettasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TasksDTO>> findAllTask() {
		try {
			Page<TasksDTO> response = this.taskService.getAllTasks(0, 50);
			
			return ResponseEntity.ok().body(response.getContent());
		} catch (RuntimeException e) {
			log.error("Unexpected error while find all task", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}  
	}

}
