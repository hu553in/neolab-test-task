package com.github.hu553in.neolab_test_task.rule.operator;

import java.util.EnumMap;
import java.util.Map;

public class OperatorMap {
    private static final Map<Operator, OperatorRunner> operators;

    static {
        operators = new EnumMap<>(Operator.class);
        operators.put(
                Operator.IN_LIST,
                (value, list) -> list.contains(value)
        );
        operators.put(
                Operator.NOT_IN_LIST,
                (value, list) -> !list.contains(value)
        );
    }

    private OperatorMap() {
    }

    public static OperatorRunner getOperatorRunner(final String name) {
        return operators.get(Operator.valueOf(name));
    }
}