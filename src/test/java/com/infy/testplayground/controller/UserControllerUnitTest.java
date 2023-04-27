package com.infy.testplayground.controller;

import com.infy.testplayground.config.AbstractUnitTest;
import com.infy.testplayground.entity.H2Entity;
import com.infy.testplayground.entity.User;
import com.infy.testplayground.repo.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerUnitTest extends AbstractUnitTest {

    private static final UserController subject = new UserController();
    private static final UserRepository repo = mock(UserRepository.class);

    @BeforeAll
    public static void init() {
        Field repoField = ReflectionUtils.findField(UserController.class, "repository");
        ReflectionUtils.makeAccessible(repoField);
        ReflectionUtils.setField(repoField, subject, repo);
    }

    @AfterEach
    public void cleanUp() {
        reset(repo);
    }

    @Test
    public void testGetById_success() {
        Long id = 1L;
        H2Entity testUser = new User()
                .setName("test")
                .setId(id);
        doReturn(Optional.of(testUser)).when(repo).findById(id);

        Optional<User> result = subject.getById(id);

        assertTrue(result.isPresent());
        assertEquals(testUser, result.get());
        verify(repo).findById(id);
    }

    @Test
    public void testGetById_repoError() {
        Long id = 1L;
        doThrow(RuntimeException.class).when(repo).findById(id);

        assertThrows(RuntimeException.class, () -> subject.getById(id));
        verify(repo).findById(id);
    }
}
