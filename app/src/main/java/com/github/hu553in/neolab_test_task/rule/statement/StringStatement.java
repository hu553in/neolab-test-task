package com.github.hu553in.neolab_test_task.rule.statement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hu553in.neolab_test_task.rule.operator.OperatorMap;
import com.github.hu553in.neolab_test_task.rule.operator.string.StringOperatorRunner;
import lombok.Getter;

public class StringStatement {
    @Getter
    private final String field;

    @Getter
    private final StringOperatorRunner operator;

    @Getter
    private final String string;

    @JsonCreator
    public StringStatement(
            @JsonProperty("field") final String field,
            @JsonProperty("operator") final String operatorName,
            @JsonProperty("string") final String string
    ) {
        this.field = field;
        this.string = string;
        this.operator = OperatorMap.getStringOperatorRunner(operatorName);
    }
}
