package dto.script;

import lombok.Data;
import lombok.NoArgsConstructor;
import domain.script.matcher.MatcherRuleEnum;

@Data
@NoArgsConstructor
public class MatcherDto {
    private MatcherRuleEnum matcherRule;
    private String param;
}
