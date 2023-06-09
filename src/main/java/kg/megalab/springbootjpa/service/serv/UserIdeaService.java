package kg.megalab.springbootjpa.service.serv;

import kg.megalab.springbootjpa.model.ideadto.UserIdeaDto;
import java.util.List;

public interface UserIdeaService {

    void saveUserIdea(UserIdeaDto dto);

    UserIdeaDto getUsers(Long id);

    List<UserIdeaDto> getAllUsers();

    boolean deleteUser(Long id);

    void putUser(UserIdeaDto dto);

}
