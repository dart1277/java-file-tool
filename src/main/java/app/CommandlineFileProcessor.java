package app;

import domain.ProcessingException;
import domain.script.FileSystemScriptServiceFactory;
import domain.script.ScriptService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CommandlineFileProcessor {

    public static void process(String[] args) {
        try {
            FileSystemScriptServiceFactory scriptServiceFactory = new FileSystemScriptServiceFactory(args);
            ScriptService scriptService = scriptServiceFactory.create();
            scriptService.run();
        } catch (ProcessingException ex) {
            handleError("Cannot process script: %s", ex);
        } catch (Exception ex) {
            handleError("An error occurred: %s", ex);
        }
    }

    private static void handleError(String s, Exception ex) {
        log.error(String.format(s, ex.getMessage()) /*, ex*/);
    }

}
