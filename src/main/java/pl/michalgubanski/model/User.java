package pl.michalgubanski.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String login;
    private String password;
    private int role;

    public User(String login, String password, int role) {

        this.setLogin(login);
        this.setPassword(password);
        this.setRole(role);

    }
    public User() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + "'" +
                ", username='" + login + "'" +
                ", password='" + password + "'" +
                ", role='" + role + "'" +
                '}';
    }
}

