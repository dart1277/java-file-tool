package adapter.script;

import domain.ProcessingException;
import domain.port.ScriptReaderPort;
import dto.script.ScriptsDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import util.json.JsonUtil;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class JsonScriptReaderPortAdapter implements ScriptReaderPort {

    private final String scriptText;

    @Override
    public ScriptsDto read() {
       try {
           return JsonUtil.read(scriptText, ScriptsDto.class);
       } catch (Exception ex) {
           String message = "JSON script file cannot be parsed";
           if(ex instanceof IllegalArgumentException) {
               message += ", " + ex.getMessage();
           }
           throw new ProcessingException(message, ex);
       }
    }
}
