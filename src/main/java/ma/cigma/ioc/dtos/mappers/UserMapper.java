package ma.cigma.ioc.dtos.mappers;

import ma.cigma.ioc.dtos.UserDTO;
import ma.cigma.ioc.entities.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class UserMapper {


    public abstract UserDTO map(User user);

}
