package kg.megalab.springbootjpa.service.serv;

import kg.megalab.springbootjpa.model.ideadto.CommentDto;

public interface CommentService {
    void saveComments(CommentDto dto);
}
