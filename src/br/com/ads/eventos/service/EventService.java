package br.com.ads.eventos.service;

import br.com.ads.eventos.model.*;
import br.com.ads.eventos.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class EventService {
    private final EventRepository repo;
    private final Map<Long, Event> events = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public EventService(EventRepository repo) { this.repo = repo; }

    public Event create(String name, String address, Category category, LocalDateTime start, LocalDateTime end, String desc) {
        long id = seq.getAndIncrement();
        Event e = new Event(id, name, address, category, start, end, desc);
        events.put(id, e);
        return e;
    }

    public List<Event> listAll() { return new ArrayList<>(events.values()); }
    public void save() { repo.saveAll(events.values()); }
}
