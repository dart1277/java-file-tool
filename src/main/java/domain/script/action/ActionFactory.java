package domain.script.action;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ActionFactory {

    private static final Map<ActionEnum, Function<String, Action>> actions = new HashMap<>();

    static {
        actions.put(ActionEnum.DELETE_FILE, DeleteFileAction::new);
        actions.put(ActionEnum.MOVE_TO, MoveToFileAction::new);
        actions.put(ActionEnum.COPY_TO, CopyToFileAction::new);
    }

    public static Action createAction(ActionEnum actionEnum, String actionParam) {
        return actions.get(actionEnum).apply(actionParam);
    }

}
