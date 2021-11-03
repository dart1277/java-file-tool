package domain.script.action;

import domain.file.FileInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Action {
    @Getter(AccessLevel.PROTECTED)
    private final String param;
    public abstract void perform(FileInfo fileInfo);

}
