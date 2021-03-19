package com.github.hu553in.neolab_test_task.entity.processor;

import com.github.hu553in.neolab_test_task.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class EntityProcessor {
    private EntityProcessor() {
    }

    public static void process(final List<Map<String, String>> entities, final List<Rule> rules)
            throws EntityProcessorException {
        rules.forEach(rule -> {
            var counter = new AtomicInteger(0);
            final var stringListStatements = rule.getStringListStatements();
            entities.forEach(entity -> {
                if (stringListStatements.stream().allMatch(stringListStatement -> {
                    final var fieldValue = entity.get(stringListStatement.getField());
                    if (fieldValue == null) {
                        throw new EntityProcessorException(
                                "Rule contains statement with field name " +
                                        "which is not presented in entity"
                        );
                    }
                    return stringListStatement.getOperator().run(
                            entity.get(stringListStatement.getField()),
                            stringListStatement.getList()
                    );
                })) counter.incrementAndGet();
            });
            log.info("{} - {}", rule.getDesc(), counter.get());
        });
    }
}
