package tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.service.Film;
import tms.service.User;
import tms.service.UserFilm;
import tms.storages.InMemoryFilmStorage;
import tms.storages.InMemoryUserFilmStorage;
import tms.storages.InMemoryUserStorage;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/film")
public class FilmController {

    @Autowired
    InMemoryFilmStorage inMemoryFilmStorage;

    @Autowired
    InMemoryUserFilmStorage inMemoryUserFilmStorage;

    @Autowired
    InMemoryUserStorage inMemoryUserStorage;

    @GetMapping
    public ModelAndView getFilms(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("films");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        modelAndView.addObject("films", inMemoryFilmStorage.getAll());
        return modelAndView;
    }

    @GetMapping(path = "/edit/{title}")
    public ModelAndView getFilm(@PathVariable String title, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("edit");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        System.out.println("title");
        System.out.println(title);

        Film film = inMemoryFilmStorage.getByTitle(title);
        if (film == null) {
            httpSession.setAttribute("messageAuth", "Enter film title\\Login!");
            modelAndView.setViewName("redirect:/user/auth");
        } else {
            if (user == null) {
                httpSession.setAttribute("messageAuth", "Enter film title\\Login!");
                modelAndView.setViewName("redirect:/user/auth");
            } else {
                UserFilm userFilm = inMemoryUserFilmStorage.getByIds(user.getId(), film.getId());
                httpSession.setAttribute("film", film);
                httpSession.setAttribute("userFilm", userFilm);
            }
        }

        return modelAndView;
    }

    @GetMapping(path = "/estimate/{title}")
    public ModelAndView estimateFilm(@PathVariable String title, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("estimate");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);

        Film film = inMemoryFilmStorage.getByTitle(title);
        if (film == null) {
            httpSession.setAttribute("messageAuth", "Enter film title\\Login!");
            modelAndView.setViewName("redirect:/user/auth");
        } else {
            if (user == null) {
                httpSession.setAttribute("messageAuth", "Enter film title\\Login!");
                modelAndView.setViewName("redirect:/user/auth");
            } else {
                UserFilm userFilm = inMemoryUserFilmStorage.getByIds(user.getId(), film.getId());
                httpSession.setAttribute("film", film);
                System.out.println(userFilm);
                httpSession.setAttribute("userfilm", userFilm);
            }
        }

        return modelAndView;
    }

    @GetMapping(path = "/create")
    public ModelAndView createView(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("create");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);

        Film film = new Film();

        UserFilm userFilm = inMemoryUserFilmStorage.getByIds(user == null ? -1 : user.getId(), film.getId());

        return modelAndView;
    }

    @PostMapping(path = "/create")
    public ModelAndView createFilm(Film film, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        film.setId(inMemoryFilmStorage.getAll().size() + 1);
        inMemoryFilmStorage.save(film);
        modelAndView.addObject( film);
        return modelAndView;
    }

    @PostMapping(path = "/edit")
    public ModelAndView updateFilm(Film film, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        inMemoryFilmStorage.updateById(film);
        modelAndView.addObject(film);
        return modelAndView;
    }


    @PostMapping(path = "/estimate")
    public ModelAndView estimateFilm(UserFilm film, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        System.out.println(film);
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        inMemoryUserFilmStorage.save(film);
        modelAndView.addObject(film);
        return modelAndView;
    }
}



