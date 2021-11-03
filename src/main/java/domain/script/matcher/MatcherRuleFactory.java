package domain.script.matcher;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MatcherRuleFactory {

    private static final Map<MatcherRuleEnum, Function<String, MatcherRule>> actions = new HashMap<>();

    static {
        actions.put(MatcherRuleEnum.EXTENSION_IS, MatcherRuleExtensionIs::new);
        actions.put(MatcherRuleEnum.EXTENSION_IS_NOT, MatcherRuleExtensionIsNot::new);
        actions.put(MatcherRuleEnum.MODIFIED_DATE_GREATER_THAN, MatcherRuleModifiedDateGreaterThan::new);
        actions.put(MatcherRuleEnum.MODIFIED_DATE_LESS_THAN, MatcherRuleModifiedDateLessThan::new);
        actions.put(MatcherRuleEnum.NAME_CONTAINS, MatcherRuleNameContains::new);
    }

    public static MatcherRule createRule(MatcherRuleEnum ruleEnum, String param) {
        return actions.get(ruleEnum).apply(param);
    }

}
