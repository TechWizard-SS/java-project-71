package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String content1 = Files.readString(Paths.get(filePath1).toAbsolutePath().normalize());
        String content2 = Files.readString(Paths.get(filePath2).toAbsolutePath().normalize());

        String ext1 = getFileExtension(filePath1);
        String ext2 = getFileExtension(filePath2);

        Map<String, Object> data1 = Parser.parse(content1, ext1);
        Map<String, Object> data2 = Parser.parse(content2, ext2);

        List<DiffNode> diff = DiffBuilder.build(data1, data2);
        return Formatter.format(diff, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception { //добавил
        return generate(filePath1, filePath2, "stylish");
    }

    private static String getFileExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
    }
}
