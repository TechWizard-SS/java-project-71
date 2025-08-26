package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeSet;
import com.fasterxml.jackson.core.type.TypeReference;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> data1 = getData(filePath1);
        Map<String, Object> data2 = getData(filePath2);

        return buildDiff(data1, data2);
    }

    // Метод для чтения и парсинга файла
    public static Map<String, Object> getData(String filePath) throws Exception {
        String content = readFile(filePath);
        return parse(content);
    }

    // Метод для чтения файла
    private static String readFile(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    // Метод для парсинга JSON с использованием TypeReference
    private static Map<String, Object> parse(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }

    // Метод для построения различий
    private static String buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        // Используем TreeSet для автоматической сортировки ключей
        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        StringBuilder result = new StringBuilder("{\n");

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 != null && value2 != null) {
                if (value1.equals(value2)) {
                    // Ключ есть в обоих файлах с одинаковым значением
                    result.append("    ").append(key).append(": ").append(value1).append("\n");
                } else {
                    // Ключ есть в обоих файлах, но значения разные
                    result.append("  - ").append(key).append(": ").append(value1).append("\n");
                    result.append("  + ").append(key).append(": ").append(value2).append("\n");
                }
            } else if (value1 != null) {
                // Ключ есть только в первом файле
                result.append("  - ").append(key).append(": ").append(value1).append("\n");
            } else {
                // Ключ есть только во втором файле
                result.append("  + ").append(key).append(": ").append(value2).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }
}
