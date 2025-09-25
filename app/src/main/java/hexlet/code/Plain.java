package hexlet.code;

import java.util.List;
import java.util.stream.Collectors;

public class Plain {
    public static String format(List<DiffNode> diff) {
        return diff.stream()
                .map(Plain::formatNode)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    private static String formatNode(DiffNode node) {
        return switch (node.getType()) {
            case "ADDED" -> String.format("Property '%s' was added with value: %s",
                    node.getKey(), formatValue(node.getNewValue()));
            case "REMOVED" -> String.format("Property '%s' was removed", node.getKey());
            case "CHANGED" -> String.format("Property '%s' was updated. From %s to %s",
                    node.getKey(), formatValue(node.getOldValue()), formatValue(node.getNewValue()));
            case "NESTED" -> node.getChildren().stream()
                    .map(Plain::formatNode)
                    .collect(Collectors.joining("\n"));
            default -> ""; // UNCHANGED — не выводим
        };
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof java.util.Map || value instanceof java.util.List) {
            return "[complex value]";
        }
        return value.toString();
    }
}
