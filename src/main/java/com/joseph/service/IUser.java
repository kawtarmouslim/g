package com.joseph.service;

import com.joseph.entity.User;

import java.util.List;

public interface IUser {
    public User save(User user);
    public User selectUser(Long id);
    public List< User > selectAllUsers();
    public boolean deleteUser(Long id);
    public boolean updateUser(User user);
}
