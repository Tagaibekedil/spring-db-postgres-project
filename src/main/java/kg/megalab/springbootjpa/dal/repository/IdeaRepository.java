package kg.megalab.springbootjpa.dal.repository;

import kg.megalab.springbootjpa.dal.entity.idea.IdeaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends CrudRepository<IdeaEntity,Long> {
}
