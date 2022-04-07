package edu.miu.lab5.service.impl;

import edu.miu.lab5.domain.AppUser;
import edu.miu.lab5.domain.Role;
import edu.miu.lab5.domain.dto.UserDto;
import edu.miu.lab5.helper.ListMapper;
import edu.miu.lab5.repo.AppUserRepo;
import edu.miu.lab5.repo.RoleRepo;
import edu.miu.lab5.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<AppUser, UserDto> listMapperUserToUserDto;

    @Autowired
    AppUserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;


    @Override
    public void saveUser(AppUser u) {

     userRepo.save(u);
    }

    @Override
    public void saveRole(Role r) {
       roleRepo.save(r);

    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
      AppUser user = userRepo.findByUserName(userName);
      Role role = roleRepo.findByName(roleName);
      user.getRoles().add(role);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);

    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(userRepo.getById(id),UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        return  (List<UserDto>) listMapperUserToUserDto.mapList(userRepo.findAll(),new UserDto());
    }

    @Override
    public List<UserDto> findByPostSize(int n) {
        return (List<UserDto>) listMapperUserToUserDto.mapList(userRepo.findByPostSize(n),new UserDto() );
    }

    @Override
    public List<UserDto> findByPostTitle(String title) {
        return (List<UserDto>) listMapperUserToUserDto.mapList(userRepo.findByPostTitle(title),new UserDto());
    }


}

