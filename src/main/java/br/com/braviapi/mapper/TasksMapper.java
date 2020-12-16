package br.com.braviapi.mapper;



import org.mapstruct.Mapper;

import br.com.braviapi.model.Tasks;
import br.com.braviapi.model.TasksDTO;

@Mapper(componentModel = "spring")
public interface TasksMapper  extends EntityMapper<TasksDTO, Tasks> {

}
