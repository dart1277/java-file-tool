package dto.script;

import domain.script.action.ActionEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActionDto {
    private ActionEnum actionName;
    private String actionParam;
}
