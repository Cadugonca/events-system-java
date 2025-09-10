package br.com.ads.eventos.app;

import br.com.ads.eventos.repository.*;
import br.com.ads.eventos.service.*;

public class Main {
    public static void main(String[] args) {
        var eventRepo = new EventRepository("events.data");
        var userRepo  = new UserRepository("users.data");

        var eventService = new EventService(eventRepo);
        var userService  = new UserService(userRepo);

        new Menu(eventService, userService).start();
    }
}
