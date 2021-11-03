package domain.script.matcher;

import domain.file.FileInfo;
import util.datetime.DateTimeUtil;

import java.time.LocalDateTime;

public class MatcherRuleModifiedDateGreaterThan extends MatcherRule {

    private final LocalDateTime targetDate;

    public MatcherRuleModifiedDateGreaterThan(String param) {
        super(param);
        targetDate = DateTimeUtil.shortDateStringLocalDateTime(param);
    }

    @Override
    public boolean test(FileInfo fileInfo) {
        return fileInfo.getModified().isAfter(targetDate);
    }
}
