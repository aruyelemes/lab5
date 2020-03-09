package kz.iitu.lab5.service;

import kz.iitu.lab5.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();
    Users save(Users user);
    Users register(Users user);
    Users getById(Long id);
    Users findByName(String name);
    Users findByPosition(String position);
}
