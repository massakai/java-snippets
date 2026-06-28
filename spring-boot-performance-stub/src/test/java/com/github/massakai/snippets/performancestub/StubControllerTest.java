package com.github.massakai.snippets.performancestub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;

class StubControllerTest {

  private final StubController controller = new StubController(new StubProperties(
      new StubResponse(200, "{\"result\":\"ok\"}"),
      List.of(new DelayPattern(90, 100), new DelayPattern(9, 500), new DelayPattern(1, 2000))
  ));

  @Test
  void chooseDelayMillisReturnsConfiguredDelay() {
    List<DelayPattern> delays = List.of(new DelayPattern(1, 123));

    assertThat(controller.chooseDelayMillis(delays)).isEqualTo(123);
  }

  @Test
  void chooseDelayMillisReturnsOneOfConfiguredDelays() {
    List<DelayPattern> delays = List.of(
        new DelayPattern(90, 100),
        new DelayPattern(9, 500),
        new DelayPattern(1, 2000)
    );

    assertThat(controller.chooseDelayMillis(delays)).isIn(100L, 500L, 2000L);
  }

  @Test
  void chooseDelayMillisRejectsEmptyDelays() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> controller.chooseDelayMillis(List.of()))
        .withMessage("At least one delay pattern is required");
  }

  @Test
  void chooseDelayMillisRejectsNonPositiveTotalWeight() {
    List<DelayPattern> delays = List.of(new DelayPattern(0, 100), new DelayPattern(0, 500));

    assertThatIllegalArgumentException()
        .isThrownBy(() -> controller.chooseDelayMillis(delays))
        .withMessage("Total delay weight must be positive");
  }
}
