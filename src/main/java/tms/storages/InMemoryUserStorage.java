package tms.storages;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tms.service.User;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InMemoryUserStorage {
    private List<User> users = new ArrayList<>();
    private User user = null;


    public boolean save(User user) {
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    public void setAuth(User user) {
        this.user = user;
    }

    public User getAuth() {
        return this.user;
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if(user == null) break;
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        return users;
    }
}


