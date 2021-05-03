package tms.models;

import jakarta.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    private int id;

    private String name;
    @NotNull
    @NotBlank
    @Size(max = 15, min = 4)
    private String login;
    @NotNull
    @NotBlank
    @Size(max = 15, min = 4)
    private String password;
    @NotNull
    @NotBlank
    @Size(max = 15, min = 4)
    private boolean admin;


    public User() {
    }

    public User(String name, String login, String password, boolean admin) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    public User(int id, String name, String login, String password, boolean admin) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, admin);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
