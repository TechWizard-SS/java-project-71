package hexlet.code;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Parser parser1 = new Parser();
        Parser parser2 = new Parser();

        parser1.parseFile(filePath1);
        parser2.parseFile(filePath2);

        List<DiffNode> diff = buildDiff(parser1.getData(), parser2.getData());
        return Formatter.format(diff, format); // делегируем выбор форматера
    }

    private static List<DiffNode> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        List<DiffNode> resultDiff = new ArrayList<>();

        // Сначала обходим все ключи из первого файла
        for (String key : data1.keySet()) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value2 == null) {
                resultDiff.add(new DiffNode(key, value1, null, "REMOVED"));
            } else if (value1.equals(value2)) {
                resultDiff.add(new DiffNode(key, value1, value2, "UNCHANGED"));
            } else if (value1 instanceof Map && value2 instanceof Map) {
                @SuppressWarnings("unchecked")
                List<DiffNode> children = buildDiff(
                        (Map<String, Object>) value1,
                        (Map<String, Object>) value2
                );
                resultDiff.add(new DiffNode(key, "NESTED", children));
            } else {
                resultDiff.add(new DiffNode(key, value1, value2, "CHANGED"));
            }
        }

        // Затем добавляем новые ключи из второго файла
        for (String key : data2.keySet()) {
            if (!data1.containsKey(key)) {
                resultDiff.add(new DiffNode(key, null, data2.get(key), "ADDED"));
            }
        }
        resultDiff.sort(Comparator.comparing(DiffNode::getKey));
        return resultDiff;
    }
}
