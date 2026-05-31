package com.github.massakai.snippets.performancestub;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StubController {

    private final StubProperties properties;

    public StubController(StubProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/stub")
    public ResponseEntity<String> stub() throws InterruptedException {
        long delayMillis = chooseDelayMillis(properties.delays());
        Thread.sleep(delayMillis);

        return ResponseEntity
                .status(properties.responses().status())
                .body(properties.responses().body());
    }

    long chooseDelayMillis(List<DelayPattern> delays) {
        if (delays.isEmpty()) {
            throw new IllegalArgumentException("At least one delay pattern is required");
        }

        int totalWeight = delays.stream()
                .mapToInt(DelayPattern::weight)
                .sum();

        if (totalWeight <= 0) {
            throw new IllegalArgumentException("Total delay weight must be positive");
        }

        int value = ThreadLocalRandom.current().nextInt(totalWeight);
        int current = 0;

        for (DelayPattern delay : delays) {
            current += delay.weight();
            if (value < current) {
                return delay.millis();
            }
        }

        return delays.get(delays.size() - 1).millis();
    }
}
