package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;
import java.util.LinkedHashMap;

public class Parser {
    public static Map<String, Object> parse(String content, String format) throws Exception {
        return switch (format.toLowerCase()) {
            case "json" -> new ObjectMapper().readValue(content, new TypeReference<LinkedHashMap<String, Object>>() {
            });
            case "yml", "yaml" -> new YAMLMapper().readValue(content,
                    new TypeReference<LinkedHashMap<String, Object>>() { });
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}
