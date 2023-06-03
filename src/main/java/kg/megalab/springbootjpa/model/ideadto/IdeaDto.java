package kg.megalab.springbootjpa.model.ideadto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import kg.megalab.springbootjpa.dal.entity.idea.IdeaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdeaDto {
    private Long id;
    @NotEmpty(message = "not.blank")
    @Size( max = 200,message = "row.limit.text")
    private String ideaText;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDt;
    private Long user;

    public IdeaDto(IdeaEntity idea) {
        this.id = idea.getId();
        this.ideaText = idea.getIdeaText();
        this.createdDt = idea.getCreatedDt();
        this.user = idea.getUser().getId();
    }
}
