package neolab_test_task.rule;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import neolab_test_task.rule.operator.OperatorMap;
import neolab_test_task.rule.operator.OperatorRunner;

public class Statement {
    @Getter
    private final String field;

    @Getter
    private final OperatorRunner operator;

    @Getter
    private final List<String> list;

    @JsonCreator
    public Statement(
        @JsonProperty("field") final String field,
        @JsonProperty("operator") final String operatorName,
        @JsonProperty("list") final List<String> list
    ) {
        this.field = field;
        this.list = list;
        this.operator = OperatorMap.getOperatorRunner(operatorName);
    }
}
