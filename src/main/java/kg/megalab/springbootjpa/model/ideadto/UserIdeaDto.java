package kg.megalab.springbootjpa.model.ideadto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.*;
import kg.megalab.springbootjpa.dal.entity.idea.UserIdeaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIdeaDto {
    private Long id;
    @NotEmpty(message = "not.blank")
    @Size(min = 5, max = 20,message = "row.limit")
    private String login;
    @Email(message = "email")
    @NotNull
    private String email;
    @Size(min = 3,max = 50,message = "row.limit.name")
    private String firstName;
    @Size(min = 3,max = 50)
    @NotBlank(message ="not.blank")
    private String lastName;
    @NotNull
    @PastOrPresent(message = "birth.date")
    private LocalDate birthDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDt;
    @GeneratedValue(generator = "sequence-generator")

    private List<IdeaDto> post;
    public UserIdeaDto(UserIdeaEntity entity) {
        this.id = entity.getId();
        this.login = entity.getLogin();
        this.email = entity.getEmail();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.birthDate =entity.getBirthDate();
        this.createdDt = entity.getCreatedDt();
        this.post = entity.getIdea().stream().map(IdeaDto::new).collect(Collectors.toList());
    }
}
