package domain.script.matcher;

import domain.file.FileInfo;
import util.datetime.DateTimeUtil;

import java.time.LocalDateTime;

public class MatcherRuleModifiedDateLessThan extends MatcherRule {
    private final LocalDateTime targetDate;

    public MatcherRuleModifiedDateLessThan(String param) {
        super(param);
        targetDate = DateTimeUtil.shortDateStringLocalDateTime(param);
    }

    @Override
    public boolean test(FileInfo fileInfo) {
        return fileInfo.getModified().isBefore(targetDate);
    }
}
