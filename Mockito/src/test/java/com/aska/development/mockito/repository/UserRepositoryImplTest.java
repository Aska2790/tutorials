package com.aska.development.mockito.repository;

import com.aska.development.mockito.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class UserRepositoryImplTest {

    private UserRepository mUserRepository;

    @Before
    public void setUp() throws Exception {
        mUserRepository = new UserRepositoryImpl();
    }

    @Test
    public void getUserByNamePositive() {
        String userName = "User1";
        User user = mUserRepository.getByName(userName);
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo(userName);
    }

    @Test
    public void getUserByNameNegative() {
        String userName = "MissingUserName";
        User user = mUserRepository.getByName(userName);
        assertThat(user).isNull();
    }

    @Test
    public void findAllUsers() {
        List<User> userList = mUserRepository.getAll();
        User searchUser = new User("User1", "User");

        assertThat(userList.get(1)).isEqualToComparingFieldByField(searchUser);
        assertThat(userList).contains(searchUser);
    }
}