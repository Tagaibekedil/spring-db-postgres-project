package kg.megalab.springbootjpa.service.impl;

import kg.megalab.springbootjpa.dal.entity.idea.LikeEntity;
import kg.megalab.springbootjpa.dal.repository.LikeRepository;
import kg.megalab.springbootjpa.model.ideadto.LikeDto;
import kg.megalab.springbootjpa.service.serv.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository repository;

    @Override
    public void saveLikes(LikeDto dto) {
        LikeEntity entity = new LikeEntity(dto);
        repository.save(entity);

    }
}
