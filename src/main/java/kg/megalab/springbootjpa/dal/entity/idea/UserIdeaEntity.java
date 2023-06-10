package kg.megalab.springbootjpa.dal.entity.idea;

import jakarta.persistence.*;
import kg.megalab.springbootjpa.model.ideadto.UserIdeaDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserIdeaEntity {
        @Id
        @GeneratedValue(generator = "sequence-us")
        @GenericGenerator(
                name = "sequence-us",
                strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                parameters ={
                @org.hibernate.annotations.Parameter(name = "sequence_names", value = "us_sequence"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        })
        private Long id;

        private String login;

        private String email;

        private String firstName;

        private String lastName;

        private LocalDate birthDate;

        private LocalDateTime Last_active_dt;

        private boolean is_actual;

        private LocalDateTime createdDt;

        @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
        private List<IdeaEntity> idea;

    public UserIdeaEntity(UserIdeaDto dto) {
        this.id = dto.getId();
        this.login = dto.getLogin();
        this.email = dto.getEmail();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.birthDate = dto.getBirthDate();
        this.createdDt = dto.getCreatedDt();
    }
    public UserIdeaEntity(Long userid) {
      this.id=userid;
    }
}

