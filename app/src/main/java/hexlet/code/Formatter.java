package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public final class Formatter {
    private Formatter() {
    }
    public static String format(List<DiffNode> diff, String formatName) throws Exception {
        return switch (formatName.toLowerCase()) {
            case "stylish" -> Stylish.format(diff);
            case "plain" -> Plain.format(diff);
            case "json" -> Json.format(diff);
            default -> throw new IllegalArgumentException("Unknown format: " + formatName);
        };
    }
}
