package hexlet.code;

import java.util.List;

public final class DiffNode {
    private final String key;
    private final Object oldValue;
    private final Object newValue;
    private final String type;
    private final List<DiffNode> children;

    public DiffNode(String key, Object oldValue, Object newValue, String type) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.type = type;
        this.children = null;
    }

    public DiffNode(String key, String type, List<DiffNode> children) {
        this.key = key;
        this.type = type;
        this.children = children;
        this.oldValue = null;
        this.newValue = null;
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
