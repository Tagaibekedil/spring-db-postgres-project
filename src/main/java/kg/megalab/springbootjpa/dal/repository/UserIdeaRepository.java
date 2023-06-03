package kg.megalab.springbootjpa.dal.repository;

import kg.megalab.springbootjpa.dal.entity.idea.UserIdeaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdeaRepository  extends CrudRepository<UserIdeaEntity,Long> {
}
