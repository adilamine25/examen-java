package ma.cigma.ioc.services.imp;

import lombok.AllArgsConstructor;
import ma.cigma.ioc.command.CreateUserCommand;
import ma.cigma.ioc.dtos.UserDTO;
import ma.cigma.ioc.dtos.mappers.UserMapper;
import ma.cigma.ioc.entities.User;
import ma.cigma.ioc.exception.BusinessException;
import ma.cigma.ioc.exception.ExceptionPayloadFactory;
import ma.cigma.ioc.repositories.UserRepository;
import ma.cigma.ioc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserDTO createUser(CreateUserCommand command) {
        User user = new User();
        user.setEmail(command.email);
        user.setFullName(command.fullName);
        return userMapper.map(userRepository.save(user));
    }

    @Override
    public User getUser(String userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new BusinessException(ExceptionPayloadFactory.USER_NOT_FOUND.get()));

    }
}
