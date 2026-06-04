package com.github.massakai.snippets.runnerdisable;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "batch.import", name = "enabled", havingValue = "true", matchIfMissing = true)
public class ImportApplicationRunner implements ApplicationRunner {

    private final ImportService importService;

    public ImportApplicationRunner(ImportService importService) {
        this.importService = importService;
    }

    @Override
    public void run(ApplicationArguments args) {
        importService.execute();
    }
}
