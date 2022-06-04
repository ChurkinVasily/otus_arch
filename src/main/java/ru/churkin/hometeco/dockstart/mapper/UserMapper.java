package ru.churkin.hometeco.dockstart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.churkin.hometeco.dockstart.dto.UserDto;
import ru.churkin.hometeco.dockstart.model.User;

@Mapper
public interface UserMapper {

    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    UserDto mapUserToUserDto(User user);


//    @Mapping(source = "numberOfSeats", target = "seatCount")
//    CarDto carToCarDto(Car car);
}
