package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    private Map<String, Object> data;

    // Метод для чтения файла
    private String readFile(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    // Метод для парсинга с использованием TypeReference
    private Map<String, Object> parseJson(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {
        });
    }

    private Map<String, Object> parseYaml(String content) throws Exception {
        YAMLMapper mapper = new YAMLMapper();
        return mapper.readValue(content, new TypeReference<>() {
        });
    }

    public Map<String, Object> getData() {
        return data;
    }

    private String getFileExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
    }

    public void parseFile(String filePath) throws Exception {
        String content = readFile(filePath);
        String format = getFileExtension(filePath);

        switch (format) {
            case "json":
                this.data = parseJson(content);
                break;
            case "yml":
                this.data = parseYaml(content);
                break;
            default:
                throw new Exception("Unsupported format");
        }
    }
}
