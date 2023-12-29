package com.joseph.service.Impl;

import com.joseph.entity.User;

import com.joseph.repository.UserRepository;
import com.joseph.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
 public class UserServiceImp implements IUser {
@Autowired
private UserRepository userRepository;
    @Override
    public User save(User user) {
    return userRepository.save(user);

    }

    @Override
    public User selectUser(Long id) {
        return userRepository.findById(id).orElse(null);

    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
            return true;
        }
        return false;
    }
    }

