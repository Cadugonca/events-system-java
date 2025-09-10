package br.com.ads.eventos.service;

import br.com.ads.eventos.model.User;
import br.com.ads.eventos.repository.UserRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {
    private final UserRepository repo;
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public UserService(UserRepository repo) { this.repo = repo; }

    public User register(String name, String email, String city) {
        long id = seq.getAndIncrement();
        User u = new User(id, name, email, city);
        users.put(id, u);
        return u;
    }

    public Optional<User> findByEmail(String email) {
        return users.values().stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public void save() { repo.saveAll(users.values()); }
}
