package com.aska.development.mockito.repository;

import com.aska.development.mockito.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    //region Fields

    private List<User> mUsers;

    //endregion

    //region Constructors

    public UserRepositoryImpl() {
        mUsers = Arrays.asList(
                new User("User0", "Admin"),
                new User("User1", "User"),
                new User("User2", "User"),
                new User("User3", "User"));
    }

    //endregion

    //region Methods

    @Override
    public List<User> getAll() {
        return mUsers;
    }

    @Override
    public User getByName(String name) {
        return mUsers.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    //endregion
}
