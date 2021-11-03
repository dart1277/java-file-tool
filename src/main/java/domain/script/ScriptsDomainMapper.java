package domain.script;

import domain.script.action.Action;
import domain.script.action.ActionFactory;
import domain.script.matcher.MatcherRuleFactory;
import dto.script.ScriptDto;
import dto.script.ScriptsDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScriptsDomainMapper {
    public static Scripts parse(ScriptsDto dto) {
        Scripts scripts = new Scripts();
        dto.getScripts().forEach(scriptDto -> {
            if(Objects.nonNull(scriptDto)) {
                Script script = new Script(mapAction(scriptDto));
                mapMatcherRules(scriptDto, script);
                scripts.addScript(script);
            }
        });
        return scripts;
    }

    private static void mapMatcherRules(ScriptDto scriptDto, Script script) {
        scriptDto.getMatchers().forEach(matcherDto -> {
            if (Objects.nonNull(matcherDto)) {
                script.addRule(MatcherRuleFactory.createRule(matcherDto.getMatcherRule(), matcherDto.getParam()));
            }
        });
    }

    private static Action mapAction(ScriptDto scriptDto) {
        return ActionFactory.createAction(scriptDto.getAction().getActionName(), scriptDto.getAction().getActionParam());
    }
}
