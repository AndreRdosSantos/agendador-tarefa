package agendadortarefas.infraestructure.business;

import agendadortarefas.infraestructure.business.dto.TarefasDTO;
import agendadortarefas.infraestructure.business.mapper.TarefasConverter;
import agendadortarefas.infraestructure.entity.TarefasEntity;
import agendadortarefas.infraestructure.enums.StatusNotificacaoEnum;
import agendadortarefas.infraestructure.repository.TarefasRepository;
import agendadortarefas.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token,TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailusuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefasEntity(dto);

        return tarefasConverter.paraTarefasDTO(
                tarefasRepository.save(entity));
    }
}
