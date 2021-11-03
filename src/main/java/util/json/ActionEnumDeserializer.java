package util.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import domain.script.action.ActionEnum;

import java.lang.reflect.Type;
import java.util.Arrays;

public class ActionEnumDeserializer implements JsonDeserializer<ActionEnum> {
    @Override
    public ActionEnum deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String actionStr = jsonElement.getAsJsonPrimitive().getAsString();
        return Arrays.stream(ActionEnum.values()).filter(action -> action.value.equalsIgnoreCase(actionStr)).findAny()
                        .orElseThrow(() -> new IllegalArgumentException(String.format("Enum value %s not recognized", actionStr)));
    }
}
