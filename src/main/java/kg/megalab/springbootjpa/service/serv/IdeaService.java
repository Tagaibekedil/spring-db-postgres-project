package kg.megalab.springbootjpa.service.serv;

import kg.megalab.springbootjpa.model.ideadto.IdeaDto;
import java.util.List;

public interface IdeaService {
    void  saveIdea(IdeaDto postDto);

    List<IdeaDto> getAllIdea();

    boolean deleteIdea(Long id);

}
