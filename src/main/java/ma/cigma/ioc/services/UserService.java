package ma.cigma.ioc.services;

import ma.cigma.ioc.command.CreateUserCommand;
import ma.cigma.ioc.dtos.UserDTO;
import ma.cigma.ioc.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getUsers(Pageable pageable);

    UserDTO createUser(CreateUserCommand command);

    User getUser(String userId);
}
