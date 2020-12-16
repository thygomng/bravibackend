package br.com.braviapi.services;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.braviapi.exceptions.NotFoundException;
import br.com.braviapi.mapper.TasksMapper;
import br.com.braviapi.model.TaskStatusEnum;
import br.com.braviapi.model.Tasks;
import br.com.braviapi.model.TasksDTO;
import br.com.braviapi.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	private final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	private TaskRepository taskRepository;
	private TasksMapper mapper;
	
	public TaskServiceImpl(TaskRepository taskRepository, TasksMapper mapper) {
		super();
		this.taskRepository = taskRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {RuntimeException.class, Exception.class})
	public TasksDTO createTask(TasksDTO taskDTO) throws RuntimeException {
		try {
			Tasks taskEntity = this.mapper.toEntity(taskDTO);
			
			taskEntity = this.taskRepository.save(taskEntity);
			log.info("Task Created. ID", taskEntity.getId());
			
			return this.mapper.toDto(taskEntity);
		} catch (RuntimeException e) {
			log.error("Error to create task.", e);
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {RuntimeException.class, Exception.class})
	public TasksDTO updateTask(TasksDTO tasksDTO) throws RuntimeException {
		try {
			Tasks taskEntity = this.mapper.toEntity(tasksDTO);
			
			taskEntity = this.taskRepository.save(taskEntity);
			log.info("Task Updated. ID", taskEntity.getId());
			
			return this.mapper.toDto(taskEntity);
		} catch (RuntimeException e) {
			log.error("Error to update task.", e);
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {RuntimeException.class, Exception.class})
	public boolean deleteTask(Long taskId) throws RuntimeException, NotFoundException {
		try {
			Optional<Tasks> taskOpt = this.taskRepository.findById(taskId);
			
			if(!taskOpt.isPresent()) {
				throw new NotFoundException();
			}
			
			this.taskRepository.delete(taskOpt.get());
			return true;
		} catch (RuntimeException e) {
			log.error("Error to delete task.", e);
			throw e;
		}
	}

	@Override
	public TasksDTO getTaskById(Long taskId) throws RuntimeException, NotFoundException {
		try {
			Optional<Tasks> response = this.taskRepository.findById(taskId);
			if(!response.isPresent()) {
				throw new NotFoundException();
			}
			return this.mapper.toDto(response.get());
		} catch (RuntimeException e) {
			log.error("Error try to find task");
			throw e;
		}
	}

	@Override
	public Page<TasksDTO> getAllTasks(int page, int size) throws RuntimeException {
		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<Tasks> response = this.taskRepository.findAll(pageable);
			
			for (Tasks tasks : response) {
				if(tasks.getInitialDate().compareTo(LocalDate.now()) <= 0) {
					tasks.setStatus(TaskStatusEnum.LATE);
				}
			}

			return response.map(this.mapper::toDto);
		} catch (RuntimeException e) {
			log.error("Error try to find task");
			throw e;
		}
	}

}
