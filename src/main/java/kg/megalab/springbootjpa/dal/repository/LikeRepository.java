package kg.megalab.springbootjpa.dal.repository;

import kg.megalab.springbootjpa.dal.entity.idea.LikeEntity;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<LikeEntity,Long> {
}
