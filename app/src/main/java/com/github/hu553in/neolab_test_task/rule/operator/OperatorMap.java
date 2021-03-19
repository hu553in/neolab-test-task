package com.github.hu553in.neolab_test_task.rule.operator;

import com.github.hu553in.neolab_test_task.rule.operator.string_list.StringListOperator;
import com.github.hu553in.neolab_test_task.rule.operator.string_list.StringListOperatorRunner;

import java.util.EnumMap;
import java.util.Map;

public class OperatorMap {
    private static final Map<StringListOperator, StringListOperatorRunner> stringListOperators;

    static {
        stringListOperators = new EnumMap<>(StringListOperator.class);
        stringListOperators.put(
                StringListOperator.IN_LIST,
                (value, list) -> list.contains(value)
        );
        stringListOperators.put(
                StringListOperator.NOT_IN_LIST,
                (value, list) -> !list.contains(value)
        );
    }

    private OperatorMap() {
    }

    public static StringListOperatorRunner getStringListOperatorRunner(final String name) {
        return stringListOperators.get(StringListOperator.valueOf(name));
    }
}
