package util.filesystem;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtil {
    public static String readFileAsString(Path path) throws IOException {
        return String.join("", Files.readAllLines(path));
    }

    public static void move(Path src, Path target) throws IOException {
        Files.move(src, target);
    }

    public static void copy(Path src, Path target) throws IOException {
        Files.copy(src, target);
    }

    public static void delete(Path src) throws IOException {
        Files.delete(src);
    }
}
