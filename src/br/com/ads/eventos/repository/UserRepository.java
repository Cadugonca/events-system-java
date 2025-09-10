package br.com.ads.eventos.repository;

import br.com.ads.eventos.model.User;

import java.io.*;
import java.util.*;

public class UserRepository {
    private final File file;
    public UserRepository(String fileName) { this.file = new File(fileName); }

    public List<User> loadAll() { return new ArrayList<>(); }
    public void saveAll(Collection<User> users) {}
}
