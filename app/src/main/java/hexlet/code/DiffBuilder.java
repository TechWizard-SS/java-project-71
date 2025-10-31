package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class DiffBuilder {
    public static List<DiffNode> build(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> allKeys = new TreeSet<>(Comparator.naturalOrder());
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        List<DiffNode> result = new ArrayList<>();

        for (String key : allKeys) {
            boolean inMap1 = map1.containsKey(key);
            boolean inMap2 = map2.containsKey(key);
            Object value1 = inMap1 ? map1.get(key) : null;
            Object value2 = inMap2 ? map2.get(key) : null;

            if (!inMap1) {
                result.add(new DiffNode(key, null, value2, "ADDED"));
            } else if (!inMap2) {
                result.add(new DiffNode(key, value1, null, "REMOVED"));
            } else if (Objects.equals(value1, value2)) {
                result.add(new DiffNode(key, value1, value2, "UNCHANGED"));
            } else {
                result.add(new DiffNode(key, value1, value2, "CHANGED"));
            }
        }

        return result;
    }
}
