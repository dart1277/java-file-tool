package adapter.script;

import domain.ProcessingException;
import domain.port.ScriptReaderPort;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import util.filesystem.FileUtil;

import java.io.IOException;
import java.nio.file.Path;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScriptReaderPortFactory {

    public static ScriptReaderPort create(String path) {
        // make decision here, currently we have only one option
        String scriptText = readScriptFile(path);
        return new JsonScriptReaderPortAdapter(scriptText);
    }

    private static String readScriptFile(String path) {
        try {
            return FileUtil.readFileAsString(Path.of(path));
        } catch (IOException ex) {
            throw new ProcessingException(String.format("Cannot script file from: %s", path), ex);
        }
    }

}
