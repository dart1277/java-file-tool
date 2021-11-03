package domain.file;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import util.datetime.DateTimeUtil;

import java.io.File;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FileInfo {
    public FileInfo(File file) {
        path = file.getAbsolutePath();
        name = file.getName();
        modified = DateTimeUtil.millisToLocalDateTime(file.lastModified());
        extension = getExtension(name);
    }
    private final String name;
    @EqualsAndHashCode.Include
    private final String path;
    private final String extension;
    private final LocalDateTime modified;

    private String getExtension(String name) {
        int extensionIndex = name.lastIndexOf('.');
        return extensionIndex >= 0 && extensionIndex + 1 < name.length()  ? name.substring(extensionIndex + 1) : "";
    }
}
