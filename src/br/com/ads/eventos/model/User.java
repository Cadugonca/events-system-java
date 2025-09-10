package br.com.ads.eventos.model;

public class User {
    private long id;
    private String name;
    private String email;
    private String city;

    public User(long id, String name, String email, String city) {
        this.id = id; this.name = name; this.email = email; this.city = city;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCity() { return city; }
}
