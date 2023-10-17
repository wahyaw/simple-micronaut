package com.example;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    @Inject
    UserService userService;

    @BeforeAll
    void cleanup(){
        userService.clean();

        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity("ghnjDSmb", "TlQrK"));
        users.add(new UserEntity("ehkkaENy", "xewZS"));
        users.add(new UserEntity("xgzIgHmi", "fPtre"));
        users.add(new UserEntity("uijAYBIn", "xjyKA"));
        users.add(new UserEntity("mVWBvsj4", "MnlPq"));
        users.add(new UserEntity("trUT7jN6", "zdLVl"));
        users.add(new UserEntity("otFocJG0", "qJnBD"));
        users.add(new UserEntity("cW9zH9gB", "QiHDi"));
        users.add(new UserEntity("BpgbkgHm", "BjRYa"));
        users.add(new UserEntity("Ah9kHgEm", "itmLL"));
        userService.addAll(users);
    }

    @Test
    void testComputeNumToSquare() {
        final List<UserEntity> allUsers = userService.getAllUsers();

        Assertions.assertEquals(
                allUsers.size(),
                10
        );
    }

}
