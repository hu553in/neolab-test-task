package neolab_test_task.rule;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Rule {
    @Getter
    private String desc;

    @Getter
    private List<Statement> statements;
}
