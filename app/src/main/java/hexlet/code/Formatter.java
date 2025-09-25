package hexlet.code;

import java.util.List;

public class Formatter {
    public static String format(List<DiffNode> diff, String formatName) {
        return switch (formatName.toLowerCase()) {
            case "stylish" -> Stylish.format(diff);
            case "plain" -> Plain.format(diff);
            case "json" -> Json.format(diff);
            default -> throw new IllegalArgumentException("Unknown format: " + formatName);
        };
    }
}
