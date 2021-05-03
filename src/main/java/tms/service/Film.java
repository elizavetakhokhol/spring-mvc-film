package tms.service;

import jakarta.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Film {
    private int id;

    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private int year;
    @NotNull
    @NotBlank
    private String genre;


    public Film(@NotBlank String title, @NotBlank int year, @NotBlank String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Film(int id, @NotBlank String title, @NotBlank int year, @NotBlank String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Film() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                year == film.year &&
                Objects.equals(title, film.title) &&
                Objects.equals(genre, film.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, genre);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
