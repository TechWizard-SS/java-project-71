package hexlet.code;

import java.util.List;

public class DiffNode {
    private final String key;
    private Object oldValue;
    private Object newValue;
    private final String type;
    private List<DiffNode> children;

    // Конструктор для простых случаев (без children)
    public DiffNode(String key, Object oldValue, Object newValue, String type) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.type = type;
    }

    public DiffNode(String key, String type, List<DiffNode> children) {
        this.key = key;
        this.type = type;
        this.children = children;
    }

    public String getKey() {
        return key;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public String getType() {
        return type;
    }

    public List<DiffNode> getChildren() {
        return children;
    }
}
