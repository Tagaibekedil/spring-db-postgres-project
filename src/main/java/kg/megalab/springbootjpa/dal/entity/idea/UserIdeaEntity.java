package kg.megalab.springbootjpa.dal.entity.idea;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import kg.megalab.springbootjpa.model.ideadto.UserIdeaDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
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
        @GeneratedValue(generator = "sequence-generation")
        @GenericGenerator(
                name = "sequence-generation",
                strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                parameters ={
                @org.hibernate.annotations.Parameter(name = "sequence_names", value = "users_sequence"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        })
        private Long id;
        private String login;
        @Column(unique = true,name = "email")
        private String email;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "birth_date")
        private LocalDate birthDate;
        @CreationTimestamp
        @Column(name = "created_dt",nullable = false)
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
        private LocalDateTime createdDt;
        @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
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

