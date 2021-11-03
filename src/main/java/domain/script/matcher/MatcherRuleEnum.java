package domain.script.matcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MatcherRuleEnum {
    NAME_CONTAINS("nameContains"),
    EXTENSION_IS("extensionIs"),
    EXTENSION_IS_NOT("extensionIsNot"),
    MODIFIED_DATE_GREATER_THAN("modifiedDateGreaterThan"),
    MODIFIED_DATE_LESS_THAN("modifiedDateLessThan");

    public final String value;
}
