package kg.megalab.springbootjpa.service.serv;

import kg.megalab.springbootjpa.model.ideadto.LikeDto;

public interface LikeService {
    void saveLikes(LikeDto dto);
}
