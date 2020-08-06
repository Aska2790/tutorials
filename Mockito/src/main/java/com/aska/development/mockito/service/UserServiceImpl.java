package com.aska.development.mockito.service;

import com.aska.development.mockito.model.User;
import com.aska.development.mockito.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository mUserRepository;

    public UserServiceImpl(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public boolean isPresent(User user) {
        return (mUserRepository.getByName(user.getName()) != null);
    }
}
