package com.github.massakai.snippets.argumentcaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  private static final Instant FIXED_INSTANT = Instant.parse("2026-07-18T00:00:00Z");

  @Mock
  private UserRepository userRepository;

  @Captor
  private ArgumentCaptor<User> userCaptor;

  private UserService userService;

  @BeforeEach
  void setUp() {
    final Clock fixedClock = Clock.fixed(FIXED_INSTANT, ZoneOffset.UTC);
    userService = new UserService(userRepository, fixedClock);
  }

  @Test
  void registerNormalizesInputBeforeSavingUser() {
    userService.register("  Alice  ", "ALICE@EXAMPLE.COM");

    verify(userRepository).save(userCaptor.capture());

    final User savedUser = userCaptor.getValue();
    assertEquals("Alice", savedUser.name());
    assertEquals("alice@example.com", savedUser.emailAddress());
    assertEquals(FIXED_INSTANT, savedUser.createdAt());
  }

  @Test
  void registerCapturesAllUsersWhenSaveIsCalledTwice() {
    userService.register("  Alice  ", "ALICE@EXAMPLE.COM");
    userService.register(" Bob ", "BOB@EXAMPLE.COM");

    verify(userRepository, times(2)).save(userCaptor.capture());

    final List<User> savedUsers = userCaptor.getAllValues();
    assertEquals(
        List.of(
            new User("Alice", "alice@example.com", FIXED_INSTANT),
            new User("Bob", "bob@example.com", FIXED_INSTANT)
        ),
        savedUsers
    );
  }
}
