package agendadortarefas.infraestructure.business.mapper;

import agendadortarefas.infraestructure.business.dto.TarefasDTO;
import agendadortarefas.infraestructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity(TarefasDTO dto);
    TarefasDTO paraTarefasDTO(TarefasEntity entity);
}
