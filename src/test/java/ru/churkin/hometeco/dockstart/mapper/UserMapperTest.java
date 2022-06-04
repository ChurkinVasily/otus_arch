package ru.churkin.hometeco.dockstart.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.churkin.hometeco.dockstart.dto.UserDto;
import ru.churkin.hometeco.dockstart.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class UserMapperTest {

    @Test
    public void shouldMapUserToUserDto(){
        User user = new User();
        user.setId(Long.valueOf("1"));
        user.setFirstName("FirstName");
        user.setUserName("UserName");
        user.setLastName("LastName");
        user.setEmail("email@email.com");
        user.setPhone("phone");

        UserDto userDto = UserMapper.INSTANCE.mapUserToUserDto(user);

        assertNotNull(userDto);
        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getFirstName(), user.getFirstName());
        assertEquals(userDto.getLastName(), user.getLastName());
        assertEquals(userDto.getPhone(), user.getPhone());
        assertEquals(userDto.getEmail(), user.getEmail());

    }

}