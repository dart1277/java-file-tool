package util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import domain.script.matcher.MatcherRuleEnum;
import domain.script.action.ActionEnum;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {
    public static <T> T read(String jsonStr, Class<T> clazz) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ActionEnum.class, new ActionEnumDeserializer());
        gsonBuilder.registerTypeAdapter(MatcherRuleEnum.class, new MatcherEnumDeserializer());
        Gson gson = gsonBuilder.create();
        return gson.fromJson(jsonStr, clazz);
    }
}
