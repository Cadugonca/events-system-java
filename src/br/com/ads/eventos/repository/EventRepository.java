package br.com.ads.eventos.repository;

import br.com.ads.eventos.model.Event;

import java.io.*;
import java.util.*;

public class EventRepository {
    private final File file;
    public EventRepository(String fileName) { this.file = new File(fileName); }

    public List<Event> loadAll() { return new ArrayList<>(); }
    public void saveAll(Collection<Event> events) {}
}
