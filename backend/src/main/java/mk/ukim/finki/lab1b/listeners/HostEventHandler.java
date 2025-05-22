package mk.ukim.finki.lab1b.listeners;

import mk.ukim.finki.lab1b.events.HostChangedEvent;
import mk.ukim.finki.lab1b.events.HostCreatedEvent;
import mk.ukim.finki.lab1b.events.HostDeletedEvent;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.service.application.CountryApplicationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HostEventHandler {
    private final CountryApplicationService countryApplicationService;

    public HostEventHandler(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @EventListener
    public void onHostCreated(HostCreatedEvent event) {
        Host host = (Host) event.getSource();
        System.out.println("Host created with ID: " + host.getId() + " and Name: " + host.getName());
        this.countryApplicationService.refreshMaterializedView();
    }

    @EventListener
    public void onHostChanged(HostChangedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }

    @EventListener
    public void onHostCDeleted(HostDeletedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
}
