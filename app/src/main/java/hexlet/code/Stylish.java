package hexlet.code;

import java.util.List;

public class Stylish {
    public static String format(List<DiffNode> diff) {
        return "{\n" + formatNested(diff, 0) + "}";
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
                            .append("\n");
                    break;
                case "REMOVED":
                    result.append(prefix)
                            .append("  - ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append("\n");
                    break;
                case "CHANGED":
                    result.append(prefix)
                            .append("  - ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append("\n");

                    result.append(prefix)
                            .append("  + ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getNewValue())
                            .append("\n");
                    break;
                case "UNCHANGED":
                    result.append(prefix)
                            .append("    ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append("\n");
                    break;
                case "NESTED":
                    result.append(prefix)
                            .append("    ")
                            .append(node.getKey())
                            .append(": {\n");

                    result.append(formatNested(node.getChildren(), prefixLevel + 1));

                    result.append(prefix)
                            .append("    }\n");
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }
}
