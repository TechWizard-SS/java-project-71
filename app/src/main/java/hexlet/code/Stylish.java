package hexlet.code;

import java.util.List;

public class Stylish {
    public static String format(List<DiffNode> diff) {
        return "{" + System.lineSeparator()  // Фикс: для открытия
                + formatNested(diff, 0) + "}";
    }

    private static String formatNested(List<DiffNode> nodes, int prefixLevel) {
        StringBuilder result = new StringBuilder();
        String prefix = " ".repeat(prefixLevel * 4); // Отступ зависит от уровня вложенности

        for (DiffNode node : nodes) {
            switch (node.getType()) {
                case "ADDED":
                    result.append(prefix)
                            .append("  + ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getNewValue())
                            .append(System.lineSeparator());
                    break;
                case "REMOVED":
                    result.append(prefix)
                            .append("  - ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append(System.lineSeparator());
                    break;
                case "CHANGED":
                    result.append(prefix)
                            .append("  - ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append(System.lineSeparator());

                    result.append(prefix)
                            .append("  + ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getNewValue())
                            .append(System.lineSeparator());
                    break;
                case "UNCHANGED":
                    result.append(prefix)
                            .append("    ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append(System.lineSeparator());
                    break;
                case "NESTED":
                    result.append(prefix)
                            .append("    ")
                            .append(node.getKey())
                            .append(": {")
                            .append(System.lineSeparator());

                    result.append(formatNested(node.getChildren(), prefixLevel + 1));

                    result.append(prefix)
                            .append("    }")
                            .append(System.lineSeparator());
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }
}
