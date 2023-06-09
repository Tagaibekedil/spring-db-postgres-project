package kg.megalab.springbootjpa.service.impl;

import kg.megalab.springbootjpa.dal.entity.idea.CommentEntity;
import kg.megalab.springbootjpa.dal.repository.CommentRepository;
import kg.megalab.springbootjpa.model.ideadto.CommentDto;
import kg.megalab.springbootjpa.service.serv.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    @Override
    public void saveComments(CommentDto dto) {
        CommentEntity entity=new CommentEntity(dto);
        repository.save(entity);
    }
}
