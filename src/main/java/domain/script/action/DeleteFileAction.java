package domain.script.action;

import domain.file.FileInfo;
import lombok.extern.slf4j.Slf4j;
import util.filesystem.FileUtil;

import java.io.IOException;
import java.nio.file.Path;

@Slf4j
public class DeleteFileAction extends Action {

    public DeleteFileAction(String param) {
        super(param);
    }

    @Override
    public void perform(FileInfo fileInfo) {
        String path = fileInfo.getPath();
        String message = String.format("Delete file: %s", path);
        log.info(message);
        try {
            FileUtil.delete(Path.of(path));
        } catch (IOException e) {
            log.error(message + " failed");
        }
    }
}
