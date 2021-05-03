package tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.service.User;
import tms.storages.InMemoryUserStorage;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    InMemoryUserStorage inMemoryUserStorage;

    @GetMapping(path = "/reg")
    public ModelAndView getReg(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView postReg(User user, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        httpSession.setAttribute("user", user);
        inMemoryUserStorage.setAuth(user);
        inMemoryUserStorage.save(user);
        httpSession.setAttribute("messageReg", "You're registered!");
        return modelAndView;

    }

    @GetMapping(path = "/auth")
    public ModelAndView getAuth(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("auth");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView postAuth( String login, String password, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        User byLogin = inMemoryUserStorage.getByLogin(login);
        if (inMemoryUserStorage.getByLogin(login) == null) {
            httpSession.setAttribute("messageAuth", "Enter you're login!");
            modelAndView.setViewName("redirect:/user/auth");
        } else
            if (!byLogin.getPassword().equals(password)) {
            httpSession.setAttribute("messageW", "Wrong password!");
            modelAndView.setViewName("redirect:/user/auth");
        } else {
            httpSession.setAttribute("messageAuth2", "You're auth!");
            httpSession.setAttribute("user", byLogin);
            inMemoryUserStorage.setAuth(byLogin);
        }

        return modelAndView;
    }


    @GetMapping(path = "/logout")
    public ModelAndView getLog(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("index");
        httpSession.setAttribute("user", null);
        inMemoryUserStorage.setAuth(null);
        return modelAndView;
    }

    @PostMapping(path = "/logout")
    public ModelAndView postLog(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("index");
        httpSession.invalidate();
        httpSession.setAttribute("user", null);
        inMemoryUserStorage.setAuth(null);
        modelAndView.setViewName("redirect:/");
        return modelAndView;

    }
}



