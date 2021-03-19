package com.github.hu553in.neolab_test_task.rule.operator;

import com.github.hu553in.neolab_test_task.rule.operator.string.StringOperator;
import com.github.hu553in.neolab_test_task.rule.operator.string.StringOperatorRunner;
import com.github.hu553in.neolab_test_task.rule.operator.string_list.StringListOperator;
import com.github.hu553in.neolab_test_task.rule.operator.string_list.StringListOperatorRunner;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class OperatorMap {
    private static final Map<
            StringOperator,
            StringOperatorRunner
            > stringOperators;
    private static final Map<
            StringListOperator,
            StringListOperatorRunner
            > stringListOperators;

    static {
        stringOperators = new EnumMap<>(StringOperator.class);
        stringOperators.put(
                StringOperator.EQUALS,
                Objects::equals
        );
        stringOperators.put(
                StringOperator.NOT_EQUALS,
                (value, string) -> !Objects.equals(value, string)
        );
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

    public static StringOperatorRunner getStringOperatorRunner(
            final String name
    ) {
        return stringOperators.get(StringOperator.valueOf(name));
    }

    public static StringListOperatorRunner getStringListOperatorRunner(
            final String name
    ) {
        return stringListOperators.get(StringListOperator.valueOf(name));
    }
}
