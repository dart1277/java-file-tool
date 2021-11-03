package util.filesystem;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DirUtil {
    public static List<File> readFilesFromPath(Path rootPath) throws IOException {
        Set<File> paths = new HashSet<>();
        Files.walkFileTree(rootPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                if (!Files.isDirectory(path)) {
                    paths.add(path.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return new ArrayList<>(paths);
    }


}
