package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffNode;

import java.util.List;

public class Json {
    public static String format(List<DiffNode> diff) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(diff);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize to JSON", e);
        }
    }
}
