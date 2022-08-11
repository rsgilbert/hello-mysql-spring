package net.passioncloud.hellomysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path="/users")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    record CreateUserRequestBody(String name, String email) {
    }

    @PostMapping("/")
    public @ResponseBody User addNewUser(@RequestBody CreateUserRequestBody requestBody) {
        System.out.println("Req body" + requestBody);
        User u = new User();
        u.setId("USER-" + new Date().getTime());
        u.setName(requestBody.name());
        u.setEmail(requestBody.email());
        u = userRepository.save(u);
        return u;
    }

    // Eg http://localhost:8080/users/   -- note trailing /
    @GetMapping("/")
    public @ResponseBody Iterable<User> allUsers() {
        return userRepository.findAll();
    }
}

