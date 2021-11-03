package domain.script.action;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ActionEnum {
    DELETE_FILE("deleteFile"),
    MOVE_TO("moveTo"),
    COPY_TO("copyTo");

    public final String value;
}
