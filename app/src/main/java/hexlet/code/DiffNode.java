package hexlet.code;

import java.util.List;

public final class DiffNode {
    private final String key;
    private final Object oldValue;
    private final Object newValue;
    private final String type;
    private final List<DiffNode> children;  // Final для consistency

    // Конструкторы и getters без изменений
    public DiffNode(String key, Object oldValue, Object newValue, String type) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.type = type;
        this.children = null;  // Для leaf
    }

    public DiffNode(String key, String type, List<DiffNode> children) {
        this.key = key;
        this.type = type;
        this.children = children;
        this.oldValue = null;
        this.newValue = null;
    }

    // Getters без изменений
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
