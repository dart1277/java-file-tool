package domain.script.action;

import domain.file.FileInfo;
import lombok.extern.slf4j.Slf4j;
import util.filesystem.FileUtil;

import java.io.IOException;
import java.nio.file.Path;

@Slf4j
public class MoveToFileAction extends Action {

    public MoveToFileAction(String param) {
        super(param);
    }

    @Override
    public void perform(FileInfo fileInfo) {
        String path = fileInfo.getPath();
        String param = getParam();
        String message = String.format("Move file: %s to %s", path, param);
        log.info(message);
        try {
            FileUtil.move(Path.of(path), Path.of(param, fileInfo.getName()));
        } catch (IOException e) {
            log.error(message + " failed");
        }
    }
}
