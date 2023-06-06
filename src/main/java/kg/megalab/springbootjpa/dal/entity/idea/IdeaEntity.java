package kg.megalab.springbootjpa.dal.entity.idea;

import jakarta.persistence.*;
import kg.megalab.springbootjpa.model.ideadto.IdeaDto;
import kg.megalab.springbootjpa.model.ideadto.LikeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ideas")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-idea")
    @GenericGenerator(
            name = "sequence-idea",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_idea", value = "ide_sequence"),
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

    @OneToMany
    private List<CommentEntity>comments;
    @OneToMany
    private List<LikeEntity>likes;
    @Column(name = "last_active_dt")
    private LocalDateTime lastActiveDt;
    @Column(name = "is_actual")
    private Boolean isActual;

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
