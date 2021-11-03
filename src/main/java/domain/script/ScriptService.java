package domain.script;

import domain.port.FileInfoReaderPort;
import domain.port.ScriptReaderPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScriptService {
    private final ScriptReaderPort scriptReaderPort;
    private final FileInfoReaderPort fileInfoReaderPort;

    public void run() {
        Scripts scripts = ScriptsDomainMapper.parse(scriptReaderPort.read());
        scripts.execute(fileInfoReaderPort);
    }

}
