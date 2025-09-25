package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Parser parser1 = new Parser();
        Parser parser2 = new Parser();

        parser1.parseFile(filePath1);
        parser2.parseFile(filePath2);

        List<DiffNode> diff = buildDiff(parser1.getData(), parser2.getData());
        return Formatter.format(diff, format); // делегируем выбор форматера
    }

    // Метод для построения различий
    private static List<DiffNode> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        List<DiffNode> resultDiff = new ArrayList<>();

        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 == null) {
                DiffNode node = new DiffNode(key, null, value2, "ADDED");
                resultDiff.add(node);
            } else if (value2 == null) {
                resultDiff.add(new DiffNode(key, value1, null, "REMOVED"));
            } else if (value1.equals(value2)) {
                resultDiff.add(new DiffNode(key, value1, null, "UNCHANGED"));
            } else if (value1 instanceof Map && value2 instanceof Map) {
                // Оба значения Map -> это вложенный объект
                // Рекурсивно вызываем buildDiff для Map
                @SuppressWarnings("unchecked") // чтобы убрать warning, если компилятор всё равно ругается
                List<DiffNode> children = buildDiff(
                        (Map<String, Object>) value1,
                        (Map<String, Object>) value2
                );
                DiffNode node = new DiffNode(key, "NESTED", children);
                resultDiff.add(node);
            } else {
                DiffNode node = new DiffNode(key, value1, value2, "CHANGED");
                resultDiff.add(node);
            }
        }
        return resultDiff;
    }
}
