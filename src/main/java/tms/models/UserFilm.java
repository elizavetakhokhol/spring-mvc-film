package tms.models;

import jakarta.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserFilm {
    private int id;

    @NotNull
    @NotBlank
    private int userId;
    @NotNull
    @NotBlank
    private int filmId;
    @NotNull
    @NotBlank
    private int point;


    public UserFilm(@NotBlank int userId, @NotBlank int filmId, @NotBlank int point) {
        this.userId = userId;
        this.filmId = filmId;
        this.point = point;
    }

    public UserFilm(int id, @NotBlank int userId, @NotBlank int filmId, @NotBlank int point) {
        this.id = id;
        this.userId = userId;
        this.filmId = filmId;
        this.point = point;
    }

    public UserFilm() { }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFilm userFilm = (UserFilm) o;
        return id == userFilm.id &&
                userId == userFilm.userId &&
                point == userFilm.point &&
                filmId == userFilm.filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, filmId, point);
    }

    @Override
    public String toString() {
        return "UserFilm{" +
                "id=" + id +
                ", userId=" + userId +
                ", filmId=" + filmId +
                ", point=" + point +
                '}';
    }
}
