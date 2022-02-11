package ma.cigma.ioc.resources;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.cigma.ioc.command.CreateUserCommand;
import ma.cigma.ioc.dtos.UserDTO;
import ma.cigma.ioc.dtos.mappers.UserMapper;
import ma.cigma.ioc.entities.User;
import ma.cigma.ioc.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("/users/{userId}")
    public UserDTO getUser(@PathVariable("userId") String userId) {
        User user = userService.getUser(userId);
        return userMapper.map(user);
    }

    @GetMapping("/users")
    public Page<UserDTO> getUser(Pageable page) {
        log.info("begin getting users ");
        Page<UserDTO> usersPage = userService.getUsers(page).map((user) -> userMapper.map(user));
        log.info("end getting users ");
        return usersPage;
    }

}
