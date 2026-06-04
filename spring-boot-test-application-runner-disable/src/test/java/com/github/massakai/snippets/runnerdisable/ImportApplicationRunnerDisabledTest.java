package com.github.massakai.snippets.runnerdisable;

import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(properties = "batch.import.enabled=false")
class ImportApplicationRunnerDisabledTest {

    @MockitoBean
    private ImportService importService;

    @Test
    void runnerDoesNotRunWhenDisabled() {
        verifyNoInteractions(importService);
    }
}
