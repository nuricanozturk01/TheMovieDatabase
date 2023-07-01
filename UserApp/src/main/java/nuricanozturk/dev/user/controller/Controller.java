package nuricanozturk.dev.user.controller;

import nuricanozturk.dev.user.data.entity.User;
import nuricanozturk.dev.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("find/all")
public class Controller {

    private final UserService repo;

    public Controller(UserService repo) {
        this.repo = repo;

    }

    @GetMapping("get")
    public List<User> getAll()
    {
        return repo.findAlll();
    }

    @PostMapping("save/user")
    public User save(@RequestBody User user)
    {
        return repo.saveUser(user);
    }
}
