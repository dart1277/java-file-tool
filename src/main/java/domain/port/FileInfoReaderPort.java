package domain.port;

import domain.file.FileInfo;

import java.util.List;

public interface FileInfoReaderPort {
    List<FileInfo> read();
}
