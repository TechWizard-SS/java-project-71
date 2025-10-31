package hexlet.code.formatters;
import hexlet.code.DiffNode;

import java.util.List;

public final class Stylish {

    private Stylish() {
    }

    public static String format(List<DiffNode> diff) {
        String content = formatNested(diff, 0);
        if (content.endsWith(System.lineSeparator())) {
            content = content.substring(0, content.length() - System.lineSeparator().length());  // Убери trailing \n
        }
        return "{" + System.lineSeparator() + content + System.lineSeparator() + "}";
    }

    private static String formatNested(List<DiffNode> nodes, int prefixLevel) {
        StringBuilder result = new StringBuilder();
        String prefix = "  ".repeat(prefixLevel + 1);  // 2 spaces base + 2*level

        for (DiffNode node : nodes) {
            switch (node.getType()) {
                case "ADDED" -> {
                    result.append(prefix)
                            .append("+ ")
                            .append(node.getKey())
                            .append(": ")
                            .append(stringifyValue(node.getNewValue()))
                            .append(System.lineSeparator());
                }
                case "REMOVED" -> {
                    result.append(prefix)
                            .append("- ")
                            .append(node.getKey())
                            .append(": ")
                            .append(stringifyValue(node.getOldValue()))
                            .append(System.lineSeparator());
                }
                case "CHANGED" -> {
                    result.append(prefix)
                            .append("- ")
                            .append(node.getKey())
                            .append(": ")
                            .append(stringifyValue(node.getOldValue()))
                            .append(System.lineSeparator());
                    result.append(prefix)
                            .append("+ ")
                            .append(node.getKey())
                            .append(": ")
                            .append(stringifyValue(node.getNewValue()))
                            .append(System.lineSeparator());
                }
                case "UNCHANGED" -> {
                    result.append(prefix)
                            .append("  ")
                            .append(node.getKey())
                            .append(": ")
                            .append(stringifyValue(node.getOldValue()))
                            .append(System.lineSeparator());
                }
                default -> throw new RuntimeException("Unknown type: '" + node.getType() + "'");
            }
        }
        return result.toString();
    }

    // Фикс: toString() для всех, включая Map/List (no [complex value] in stylish)
    private static String stringifyValue(Object value) {
        if (value == null) {
            return "null";
        }
        return value.toString();  // Strings/booleans/numbers as is, Map=[key=value, ...], List=[a, b]
    }
}
