package kg.megalab.springbootjpa.model.ideadto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megalab.springbootjpa.dal.entity.idea.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String comment;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDt;
    private Long entity;

    public CommentDto(CommentEntity entity) {
        this.id = entity.getId();
        this.comment = entity.getComment();
        this.createdDt=entity.getCreatedDt();
        this.entity = entity.getIdea().getId();
    }
}
