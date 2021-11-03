package domain.script;

import adapter.file.FileInfoReaderPortFactory;
import adapter.script.ScriptReaderPortFactory;
import domain.ProcessingException;
import domain.port.FileInfoReaderPort;
import domain.port.ScriptReaderPort;
import lombok.RequiredArgsConstructor;
import org.apache.commons.cli.ParseException;
import util.args.CommandlineArgsUtil;

import java.util.Map;

@RequiredArgsConstructor
public class FileSystemScriptServiceFactory implements ScriptServiceFactory{

    private final String[] args;

    @Override
    public ScriptService create() {
        Map<CommandlineArgsUtil.CommandlineArg, String> commandlineArgs = parseInputArgs();
        FileInfoReaderPort fileInfoReaderPort = FileInfoReaderPortFactory.create(commandlineArgs.get(CommandlineArgsUtil.CommandlineArg.DIR));
        ScriptReaderPort scriptReaderPort = ScriptReaderPortFactory.create(commandlineArgs.get(CommandlineArgsUtil.CommandlineArg.SCRIPTS));
        return new ScriptService(scriptReaderPort, fileInfoReaderPort);
    }

    private Map<CommandlineArgsUtil.CommandlineArg, String> parseInputArgs() {
        try {
            return CommandlineArgsUtil.parseArgs(args);
        } catch (ParseException e) {
            throw new ProcessingException(String.format("Command line arguments cannot be parsed: %s", e.getMessage()), e);
        }
    }
}
