package domain.script.matcher;

import domain.file.FileInfo;
import org.apache.commons.lang3.StringUtils;

public class MatcherRuleExtensionIs extends MatcherRule {

    public MatcherRuleExtensionIs(String param) {
        super(param);
    }

    @Override
    public boolean test(FileInfo fileInfo) {
        return StringUtils.equalsIgnoreCase(getParam(), fileInfo.getExtension());
    }
}
