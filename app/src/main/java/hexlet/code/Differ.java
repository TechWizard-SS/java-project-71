package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public final class Differ {

    private Differ() {
    }

    public static String generate(String format, String filePath1, String filePath2) throws Exception {
        Path resourcesDir = Paths.get("src", "main", "resources");
        Path fullPath1 = resourcesDir.resolve(filePath1).toAbsolutePath().normalize();
        Path fullPath2 = resourcesDir.resolve(filePath2).toAbsolutePath().normalize();

        String content1 = Files.readString(fullPath1);
        String content2 = Files.readString(fullPath2);

        String ext1 = getFileExtension(filePath1);
        String ext2 = getFileExtension(filePath2);

        Map<String, Object> data1 = Parser.parse(content1, ext1);
        Map<String, Object> data2 = Parser.parse(content2, ext2);

        List<DiffNode> diff = DiffBuilder.build(data1, data2);
        return Formatter.format(diff, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate("stylish", filePath1, filePath2);
    }

    private static String getFileExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
    }
}
