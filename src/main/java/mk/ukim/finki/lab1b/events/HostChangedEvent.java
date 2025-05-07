package mk.ukim.finki.lab1b.events;

import lombok.Getter;
import mk.ukim.finki.lab1b.model.Domain.Host;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class HostChangedEvent extends ApplicationEvent {
    private final LocalDateTime when;

    public HostChangedEvent(Host source) {
        super(source);
        this.when = LocalDateTime.now();
    }
}
