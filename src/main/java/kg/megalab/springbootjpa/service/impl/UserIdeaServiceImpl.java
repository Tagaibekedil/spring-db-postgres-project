package kg.megalab.springbootjpa.service.impl;

import kg.megalab.springbootjpa.dal.entity.idea.UserIdeaEntity;
import kg.megalab.springbootjpa.dal.repository.UserIdeaRepository;
import kg.megalab.springbootjpa.exception.EmptyListException;
import kg.megalab.springbootjpa.model.ideadto.UserIdeaDto;
import kg.megalab.springbootjpa.service.serv.UserIdeaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserIdeaServiceImpl implements UserIdeaService {

    private final UserIdeaRepository userIdeaRepository;

    @Override
    public void saveUserIdea(UserIdeaDto dto) {
        UserIdeaEntity userIdeaEntity = new UserIdeaEntity(dto);
        userIdeaRepository.save(userIdeaEntity);
    }

    @Override
    public UserIdeaDto getUsers(Long id) {
        Optional<UserIdeaEntity> entities = userIdeaRepository.findById(id);
        if (entities.isEmpty()) {
            throw new EmptyListException("empty.list");
        }
        return new UserIdeaDto(entities.get());
    }

    @Override
    public List<UserIdeaDto> getAllUsers() {
        List<UserIdeaEntity> entities = (List<UserIdeaEntity>) userIdeaRepository.findAll();
        return entities.stream().map(UserIdeaDto::new).collect(Collectors.toList());
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean delete = false;
        Optional<UserIdeaEntity> entity = userIdeaRepository.findById(id);
        if (entity.isPresent()) {
            userIdeaRepository.delete(entity.get());
            delete = true;
        } else
            throw new EmptyListException("empty.list");
        return delete;
    }

    @Override
    public void putUser(UserIdeaDto dto) {
        UserIdeaEntity entity = userIdeaRepository.findById(dto.getId()).orElseThrow(() -> new EmptyListException("list.empty"));
        entity.setLogin(dto.getLogin());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthDate(dto.getBirthDate());
        userIdeaRepository.save(entity);
    }
}
