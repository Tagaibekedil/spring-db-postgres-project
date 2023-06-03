package kg.megalab.springbootjpa.dal.entity.idea;

import jakarta.persistence.*;
import kg.megalab.springbootjpa.model.ideadto.IdeaDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ideas")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-g")
    @GenericGenerator(
            name = "sequence-g",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_idea", value = "id_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    private Long id;
    @Column(name = "idea_text")
    private String ideaText;
    @Column(name = "created_dt", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserIdeaEntity user;

    public IdeaEntity(IdeaDto ideaDto) {
        this.id = ideaDto.getId();
        this.ideaText = ideaDto.getIdeaText();
        this.createdDt = ideaDto.getCreatedDt();
        this.user = new UserIdeaEntity(ideaDto.getId());
    }
    public IdeaEntity(Long ideaId) {
        this.id = ideaId;
    }
}
