package tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tms.service.User;
import tms.storages.InMemoryUserStorage;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class IndexController {
    @Autowired
    InMemoryUserStorage inMemoryUserStorage;

    @GetMapping(path = "/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        modelAndView.addObject("name", "Guest");
        return modelAndView;
    }

    @GetMapping(path = "/index2")
    public ModelAndView index2(@RequestParam String name, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        User user = inMemoryUserStorage.getAuth();
        httpSession.setAttribute("user", user);
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}