package com.github.hu553in.neolab_test_task.rule;

import com.github.hu553in.neolab_test_task.rule.statement.StringListStatement;
import com.github.hu553in.neolab_test_task.rule.statement.StringStatement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Rule {
    @Getter
    private String desc;

    @Getter
    private List<StringStatement> stringStatements;

    @Getter
    private List<StringListStatement> stringListStatements;
}
