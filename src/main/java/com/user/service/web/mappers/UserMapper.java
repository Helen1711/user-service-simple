package com.user.service.web.mappers;


import com.user.service.model.User;
import com.user.service.web.dto.UserDto;

public class UserMapper {
    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAge(user.getAge());
        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        return user;
    }
}
