package com.github.hu553in.neolab_test_task.entity.processor;

import com.github.hu553in.neolab_test_task.rule.Rule;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class EntityProcessor {
    private static final String EXCEPTION_MESSAGE =
            "Unable to process entities: " +
                    "Rule contains statement with field " +
                    "which is not presented in entity name ";

    private EntityProcessor() {
    }

    public static void process(
            final List<Map<String, String>> entities,
            final List<Rule> rules
    ) throws EntityProcessorException {
        rules.forEach(rule -> {
            var entitiesRuleCounter = new AtomicInteger(0);
            final var stringStatements = rule.getStringStatements();
            final var stringListStatements = rule.getStringListStatements();
            entities.forEach(entity -> {
                boolean entityRuleResult = true;
                if (stringStatements != null) {
                    entityRuleResult = stringStatements.stream().allMatch(stringStatement -> {
                        final var fieldValue = entity.get(stringStatement.getField());
                        if (fieldValue == null) throw new EntityProcessorException(EXCEPTION_MESSAGE);
                        return stringStatement.getOperator().run(
                                fieldValue,
                                stringStatement.getString()
                        );
                    });
                }
                if (stringListStatements != null) {
                    entityRuleResult &= stringListStatements.stream().allMatch(stringListStatement -> {
                        final var fieldValue = entity.get(stringListStatement.getField());
                        if (fieldValue == null) throw new EntityProcessorException(EXCEPTION_MESSAGE);
                        return stringListStatement.getOperator().run(
                                fieldValue,
                                stringListStatement.getList()
                        );
                    });
                }
                if (entityRuleResult) entitiesRuleCounter.incrementAndGet();
            });
            log.info("{} - {}", rule.getDesc(), entitiesRuleCounter.get());
        });
    }
}
