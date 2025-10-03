package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Plain {
    public static String format(List<DiffNode> diff) {
        return format(diff, ""); // вызываем вспомогательный метод с пустым родительским ключом
    }

    // Новый вспомогательный метод, принимающий родительский ключ
    private static String format(List<DiffNode> nodes, String parentKey) {
        return nodes.stream()
                .map(node -> formatNode(node, parentKey)) // передаём родительский ключ в formatNode
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("\r\n"));
    }

    // Изменённый метод, принимающий родительский ключ
    private static String formatNode(DiffNode node, String parentKey) {
        // Формируем текущий ключ: если родитель есть, то parent.child, иначе просто child
        String currentKey = parentKey.isEmpty() ? node.getKey() : parentKey + "." + node.getKey();

        return switch (node.getType()) {
            case "ADDED" -> String.format("Property '%s' was added with value: %s",
                    currentKey, formatValue(node.getNewValue()));
            case "REMOVED" -> String.format("Property '%s' was removed", currentKey);
            case "CHANGED" -> String.format("Property '%s' was updated. From %s to %s",
                    currentKey, formatValue(node.getOldValue()), formatValue(node.getNewValue()));
            case "NESTED" -> format(node.getChildren(), currentKey); // передаём текущий ключ как родительский для вложенных
            default -> ""; // UNCHANGED — не выводим
        };
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String || value instanceof Boolean) {
            return "'" + value + "'";
        }
        if (value instanceof Map || value instanceof java.util.List) {
            return "[complex value]";
        }
        return value.toString();
    }
}
