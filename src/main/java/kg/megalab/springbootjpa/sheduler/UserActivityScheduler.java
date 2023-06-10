package kg.megalab.springbootjpa.sheduler;

import kg.megalab.springbootjpa.dal.entity.idea.IdeaEntity;
import kg.megalab.springbootjpa.service.serv.IdeaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserActivityScheduler {

    private final IdeaService ideaService;

    @Scheduled(cron = "*/15 * * * * *")
    private void getNewIdeas() {

        LocalDateTime days = LocalDateTime.now().minusDays(7);
        List<IdeaEntity> usersNotTrue = ideaService.getAllIdea().stream().map(IdeaEntity::new).toList();
        for (IdeaEntity dto : usersNotTrue) {
            LocalDateTime ideasLastActiveDt = dto.getLast_active_dt();
            if (days.isAfter(ideasLastActiveDt)) {
                log.info("Не актуальный пользовательудален!Номер ID ="+dto.getId());
                ideaService.deleteIdea(dto.getId());
            }
        }
    }
}
