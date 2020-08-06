package com.aska.development.mockito.repository;

import com.aska.development.mockito.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    User getByName(String name);
}
