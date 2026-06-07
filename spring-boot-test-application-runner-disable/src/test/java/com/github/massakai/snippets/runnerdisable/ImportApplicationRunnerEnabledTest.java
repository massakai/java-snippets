package com.github.massakai.snippets.runnerdisable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(properties = "startup.import.enabled=true")
class ImportApplicationRunnerEnabledTest {

    @MockitoBean
    private ImportService importService;

    @Test
    void runnerRunsWhenEnabled() {
        verify(importService).execute();
        verifyNoMoreInteractions(importService);
    }
}
