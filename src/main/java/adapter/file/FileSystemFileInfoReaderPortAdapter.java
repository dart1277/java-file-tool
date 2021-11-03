package adapter.file;

import domain.ProcessingException;
import domain.file.FileInfo;
import domain.port.FileInfoReaderPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import util.filesystem.DirUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class FileSystemFileInfoReaderPortAdapter implements FileInfoReaderPort {

    private final Path rootPath;

    @Override
    public List<FileInfo> read() {
        try {
            return DirUtil.readFilesFromPath(rootPath)
                    .stream().map(FileInfo::new).collect(Collectors.toList());
        } catch (IOException ex) {
            throw new ProcessingException(String.format("Cannot get file list from: %s", rootPath.toFile().getAbsolutePath()), ex);
        }
    }
}
