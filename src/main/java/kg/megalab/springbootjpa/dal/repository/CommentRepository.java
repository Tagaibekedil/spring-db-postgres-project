package kg.megalab.springbootjpa.dal.repository;

import kg.megalab.springbootjpa.dal.entity.idea.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity,Long> {
}
