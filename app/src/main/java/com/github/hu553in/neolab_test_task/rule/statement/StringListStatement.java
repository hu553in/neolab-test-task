package com.github.hu553in.neolab_test_task.rule.statement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hu553in.neolab_test_task.rule.operator.OperatorMap;
import com.github.hu553in.neolab_test_task.rule.operator.OperatorRunner;
import lombok.Getter;

import java.util.List;

public class StringListStatement {
    @Getter
    private final String field;

    @Getter
    private final OperatorRunner operator;

    @Getter
    private final List<String> list;

    @JsonCreator
    public StringListStatement(
            @JsonProperty("field") final String field,
            @JsonProperty("operator") final String operatorName,
            @JsonProperty("list") final List<String> list
    ) {
        this.field = field;
        this.list = list;
        this.operator = OperatorMap.getOperatorRunner(operatorName);
    }
}
