package domain.script.matcher;

import domain.file.FileInfo;
import org.apache.commons.lang3.StringUtils;

public class MatcherRuleNameContains extends MatcherRule {
    public MatcherRuleNameContains(String param) {
        super(param);
    }

    @Override
    public boolean test(FileInfo fileInfo) {
        return StringUtils.contains(fileInfo.getName(), getParam());
    }
}
