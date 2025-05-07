package mk.ukim.finki.lab1b.jobs;

import mk.ukim.finki.lab1b.service.application.HostApplicationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final HostApplicationService hostApplicationService;

    public ScheduledTasks(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    //@Scheduled(cron = "*/59 * * * * *")
    @Scheduled(cron = "0 0 0 * * ?")
    public void refreshMaterializedView() {
        System.out.println("Refreshed materialized view");
        this.hostApplicationService.refreshMaterializedView();
    }
}
