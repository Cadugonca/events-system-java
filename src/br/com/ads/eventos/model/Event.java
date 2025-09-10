package br.com.ads.eventos.model;

import java.time.LocalDateTime;

public class Event {
    private long id;
    private String name;
    private String address;
    private Category category;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;

    public Event(long id, String name, String address, Category category, LocalDateTime start, LocalDateTime end, String description) {
        this.id = id; this.name = name; this.address = address; this.category = category;
        this.start = start; this.end = end; this.description = description;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public Category getCategory() { return category; }
    public LocalDateTime getStart() { return start; }
    public LocalDateTime getEnd() { return end; }
    public String getDescription() { return description; }
}
