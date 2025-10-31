package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String content1 = Files.readString(Paths.get(filePath1).toAbsolutePath().normalize());
        String content2 = Files.readString(Paths.get(filePath2).toAbsolutePath().normalize());

        String ext1 = getFileExtension(filePath1);
        String ext2 = getFileExtension(filePath2);

        Map<String, Object> data1 = Parser.parse(content1, ext1);
        Map<String, Object> data2 = Parser.parse(content2, ext2);

        List<DiffNode> diff = DiffBuilder.build(data1, data2);
        return Formatter.format(diff, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception { //добавил
        return generate(filePath1, filePath2, "stylish");
    }

    private static String getFileExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
    }

//    public static List<DiffNode> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
//        Set<String> allKeys = new TreeSet<>(Comparator.naturalOrder());
//        allKeys.addAll(map1.keySet());
//        allKeys.addAll(map2.keySet());
//
//        List<DiffNode> result = new ArrayList<>();
//
//        for (String key : allKeys) {
//            boolean inMap1 = map1.containsKey(key);
//            boolean inMap2 = map2.containsKey(key);
//            Object value1 = inMap1 ? map1.get(key) : null;
//            Object value2 = inMap2 ? map2.get(key) : null;
//
//            if (!inMap1) {
//                result.add(new DiffNode(key, null, value2, "ADDED"));
//            } else if (!inMap2) {
//                result.add(new DiffNode(key, value1, null, "REMOVED"));
//            } else if (Objects.equals(value1, value2)) {
//                result.add(new DiffNode(key, value1, value2, "UNCHANGED"));
//            } else {
//                result.add(new DiffNode(key, value1, value2, "CHANGED"));
//            }
//        }
//
//        return result;
//    }
}
