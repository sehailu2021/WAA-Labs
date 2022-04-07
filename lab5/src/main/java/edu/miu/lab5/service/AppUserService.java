package edu.miu.lab5.service;

import edu.miu.lab5.domain.AppUser;
import edu.miu.lab5.domain.Role;
import edu.miu.lab5.domain.dto.UserDto;

import java.util.List;

public interface AppUserService {
    void saveUser(AppUser u);
    void saveRole(Role r);

    void addRoleToUser(String userName, String roleName);

    void delete(long id);

    UserDto getById(long id);

    List<UserDto> getAll();

    List<UserDto> findByPostSize(int n);

    List<UserDto> findByPostTitle(String title);


}
