package com.adityapdev.ChaChing_api.service.interfaces;

import com.adityapdev.ChaChing_api.dto.UserDetailDto;
import com.adityapdev.ChaChing_api.dto.RegisterNewUserDto;

import java.util.List;

public interface IUserService {
    UserDetailDto registerNewUser(RegisterNewUserDto registerNewUserDto);
    List<UserDetailDto> getAllUsers();
}
