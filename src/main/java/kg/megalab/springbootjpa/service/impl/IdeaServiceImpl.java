package kg.megalab.springbootjpa.service.impl;

import kg.megalab.springbootjpa.dal.entity.idea.IdeaEntity;
import kg.megalab.springbootjpa.dal.repository.IdeaRepository;
import kg.megalab.springbootjpa.model.ideadto.IdeaDto;
import kg.megalab.springbootjpa.service.serv.IdeaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class IdeaServiceImpl implements IdeaService {
    private final IdeaRepository ideaRepository;
    @Override
    public void saveIdea(IdeaDto postDto) {
        IdeaEntity entity=new IdeaEntity(postDto);
        ideaRepository.save(entity);
    }

    @Override
    public List<IdeaDto> getIdea() {
        List<IdeaEntity>entities= (List<IdeaEntity>) ideaRepository.findAll();
        return entities.stream().map(IdeaDto::new).collect(Collectors.toList());
    }
    public boolean deleteIdea(Long id) {
        boolean delete=false;
        Optional<IdeaEntity> entity=ideaRepository.findById(id);
        if (entity.isPresent()){
            ideaRepository.delete(entity.get());
            delete=true;
        }
        return delete;
    }


    }

