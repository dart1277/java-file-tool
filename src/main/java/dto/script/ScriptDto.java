package dto.script;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ScriptDto {
    private String name;
    private List<MatcherDto> matchers;
    private ActionDto action;
}
