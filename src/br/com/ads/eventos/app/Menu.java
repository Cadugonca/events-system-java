package br.com.ads.eventos.app;

import br.com.ads.eventos.model.*;
import br.com.ads.eventos.service.*;
import br.com.ads.eventos.util.DateTimeUtil;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    private final Scanner in = new Scanner(System.in);
    private final EventService eventService;
    private final UserService userService;
    private final NotificationService notify = new NotificationService();
    private User currentUser;

    public Menu(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    public void start() {
        System.out.println("== Sistema de Eventos - Console ==");
        auth();
        loop();
    }

    private void auth() {
        System.out.println("1) Login  2) Cadastrar");
        int op = Integer.parseInt(in.nextLine());
        if (op == 2) {
            System.out.print("Nome: ");
            String name = in.nextLine();
            System.out.print("Email: ");
            String email = in.nextLine();
            System.out.print("Cidade: ");
            String city = in.nextLine();
            currentUser = userService.register(name, email, city);
            System.out.println("Conta criada!\n");
        } else {
            System.out.print("Email: ");
            String email = in.nextLine();
            currentUser = userService.findByEmail(email).orElse(null);
            if (currentUser == null) {
                System.out.println("Usuário não encontrado. Cadastre-se.");
                auth();
            } else {
                System.out.println("Bem-vindo, " + currentUser.getName());
            }
        }
    }

    private void loop() {
        while (true) {
            System.out.println("\n---- Menu ----");
            System.out.println("1) Cadastrar evento");
            System.out.println("2) Listar todos os eventos");
            System.out.println("0) Sair");
            int op = Integer.parseInt(in.nextLine());
            switch (op) {
                case 1 -> cadastrarEvento();
                case 2 -> listarTodos();
                case 0 -> { eventService.save(); userService.save(); return; }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void cadastrarEvento() {
        System.out.print("Nome: ");
        String name = in.nextLine();
        System.out.print("Endereço: ");
        String address = in.nextLine();
        System.out.println("Categoria: 1) FESTA  2) SHOW");
        int cat = Integer.parseInt(in.nextLine());
        Category category = (cat == 1 ? Category.FESTA : Category.SHOW);
        System.out.print("Início (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = DateTimeUtil.parse(in.nextLine());
        System.out.print("Descrição: ");
        String desc = in.nextLine();
        eventService.create(name, address, category, start, null, desc);
        System.out.println("Evento criado!");
    }

    private void listarTodos() {
        for (var e : eventService.listAll()) {
            System.out.println("[" + e.getId() + "] " + e.getName() + " - " + e.getCategory() + " - " + e.getStart());
        }
    }
}
