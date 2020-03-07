package kz.iitu.lab5.dao;

import kz.iitu.lab5.model.Users;

public interface UserDao {
    int unsertUser(Users record);
    Users selectUser(int key);
}
