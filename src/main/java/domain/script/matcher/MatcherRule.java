package domain.script.matcher;

import domain.file.FileInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class MatcherRule {
    @Getter(AccessLevel.PROTECTED)
    private final String param;
    public abstract boolean test(FileInfo fileInfo);
}
