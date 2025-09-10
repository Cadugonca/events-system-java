package br.com.ads.eventos.service;

import br.com.ads.eventos.model.Event;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationService {
    public void printOngoing(List<Event> ongoing, LocalDateTime now) {
        System.out.println("Eventos em andamento: " + ongoing.size());
    }
}
