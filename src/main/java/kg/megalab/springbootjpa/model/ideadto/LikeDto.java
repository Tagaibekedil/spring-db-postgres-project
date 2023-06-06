package kg.megalab.springbootjpa.model.ideadto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megalab.springbootjpa.dal.entity.idea.LikeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {
    private Long id;
    private String like;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDt;
    private Long idea;

    public LikeDto(LikeEntity entity) {
        this.id = entity.getId();
        this.like = entity.getLike();
        this.createdDt = entity.getCreatedDt();
        this.idea=entity.getIdea().getId();
    }

}
