package domain.script;

import domain.file.FileInfo;
import domain.port.FileInfoReaderPort;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Scripts {

    private List<Script> scripts = new ArrayList<>();

    public void addScript(Script script) {
        scripts.add(script);
    }

    public void execute(FileInfoReaderPort fileInfoReaderPort) {
        scripts.forEach(script -> script.execute(fileInfoReaderPort));
    }
}
