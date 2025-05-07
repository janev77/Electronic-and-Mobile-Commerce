package mk.ukim.finki.lab1b.events;

import lombok.Getter;
import mk.ukim.finki.lab1b.model.Domain.Host;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class HostCreatedEvent extends ApplicationEvent {
    private final LocalDateTime when;

    public HostCreatedEvent(Host source) {
        super(source);
        this.when = LocalDateTime.now();
    }
}
