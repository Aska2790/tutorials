package com.aska.development.mockito.service;

import com.aska.development.mockito.model.User;
import com.aska.development.mockito.repository.UserRepository;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    @Mock
    private UserRepository mUserRepository;
    private UserService mUserService;

    public UserServiceImplTest() {
        MockitoAnnotations.initMocks(this);
        mUserService = new UserServiceImpl(mUserRepository);
    }

    @Test
    public void isPresentPositive() {
        String userName = "User1";
        User user = new User(userName);

        given(mUserRepository.getByName(userName)).willReturn(new User(userName));

        boolean present = mUserService.isPresent(user);
        assertThat(present).isTrue();

        verify(mUserRepository).getByName(userName);
    }

    @Test(expected = Exception.class)
    public void isPresentNegative() {
        String userName = "MissingUserName";
        User user = new User(userName);

        given(mUserRepository.getByName(anyString())).willThrow(Exception.class);

        mUserService.isPresent(user);
    }

    @Test
    public void argumentCaptor() {
        String userName = "User1";
        User user = new User(userName);

        given(mUserRepository.getByName(anyString())).willReturn(new User(userName));

        mUserService.isPresent(user);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mUserRepository).getByName(argumentCaptor.capture());
        String value = argumentCaptor.getValue();

        assertThat(value).isEqualTo(userName);
    }
}