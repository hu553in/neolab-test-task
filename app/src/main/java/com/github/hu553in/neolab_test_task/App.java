package com.github.hu553in.neolab_test_task;

import com.github.hu553in.neolab_test_task.entity.processor.EntityProcessor;
import com.github.hu553in.neolab_test_task.entity.reader.EntityReader;
import com.github.hu553in.neolab_test_task.rule.reader.RuleReader;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;

@Slf4j
public class App {
    private App() {
    }

    public static void main(final String[] args) {
        try {
            if (args.length < 2) {
                throw new IllegalArgumentException(
                        "Invalid CLI args (expected: <entities_path> <rules_path>)"
                );
            }
            final var entities = EntityReader.read(Paths.get(args[0]));
            final var rules = RuleReader.read(Paths.get(args[1]));
            EntityProcessor.process(entities, rules);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
    }
}
