package adapter.file;

import domain.port.FileInfoReaderPort;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.file.Path;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileInfoReaderPortFactory {

    public static FileInfoReaderPort create(String rootPath) {
        // make decision here, currently we have only one option
        return new FileSystemFileInfoReaderPortAdapter(Path.of(rootPath));
    }

}
