package util.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import domain.script.matcher.MatcherRuleEnum;

import java.lang.reflect.Type;
import java.util.Arrays;

public class MatcherEnumDeserializer implements JsonDeserializer<MatcherRuleEnum> {
    @Override
    public MatcherRuleEnum deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String ruleStr = jsonElement.getAsJsonPrimitive().getAsString();
        return Arrays.stream(MatcherRuleEnum.values()).filter(rule -> rule.value.equalsIgnoreCase(ruleStr)).findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Enum value %s not recognized", ruleStr)));
    }
}
