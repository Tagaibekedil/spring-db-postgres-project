package kg.megalab.springbootjpa.dal.entity.idea;

import jakarta.persistence.*;
import kg.megalab.springbootjpa.model.ideadto.CommentDto;
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
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-c")
    @GenericGenerator(
            name = "sequence-c",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_idea", value = "com_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })

    private Long id;

    private String comment;

    @Column(name = "created_dt")

    @CreationTimestamp
    private LocalDateTime createdDt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idea_id")
    private IdeaEntity idea;

    public CommentEntity(CommentDto dto) {
        this.id =dto.getId();
        this.comment = dto.getComment();
        this.createdDt=dto.getCreatedDt();
        this.idea = new IdeaEntity(dto.getId());
    }
}
