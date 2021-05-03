package tms.storages;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tms.service.UserFilm;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InMemoryUserFilmStorage {
    private List<UserFilm> userUserFilms = new ArrayList<>();


    public boolean save(UserFilm film) {
        for (UserFilm cFilm : userUserFilms) {
            if(film == null) break;
            if (cFilm.getUserId() == film.getUserId() && cFilm.getFilmId() == film.getFilmId()) {
                cFilm.setPoint(film.getPoint());
                return true;
            }
        }

        userUserFilms.add(film);
        return true;
    }

    public UserFilm getByIds(int userId, int filmId) {
        for (UserFilm film : userUserFilms) {
            if(film == null) break;
            if (film.getUserId() == userId && film.getFilmId() == filmId) {
                return film;
            }
        }
        return null;
    }

    public List<UserFilm> getAll() {
        return new ArrayList<>(userUserFilms);
    }
}


