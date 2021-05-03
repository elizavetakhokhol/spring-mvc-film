package tms.storages;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tms.models.Film;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InMemoryFilmStorage {
    private List<Film> films = new ArrayList<>();


    public boolean save(Film film) {
        if (films.contains(film)) {
            return false;
        }
        films.add(film);
        return true;
    }

    public Film getByTitle(String title) {
        for (Film film : films) {
            if(film == null) break;
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        return null;
    }

    public void updateById(Film newFilm) {
        for (Film film : films) {
            if(film == null) break;
            if (film.getId() == newFilm.getId()) {
                film.setTitle(newFilm.getTitle());
                film.setGenre(newFilm.getGenre());
                film.setYear(newFilm.getYear());
            }
        }
    }

    public List<Film> getAll() {
        return new ArrayList<>(films);
    }
}


