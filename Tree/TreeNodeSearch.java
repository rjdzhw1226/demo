package Tree;

public class TreeNodeSearch<T> {
    public TreeNodeSearch<T> left;
    public TreeNodeSearch<T> right;
    public T value;
    public int key;

    public TreeNodeSearch() {
    }

    public TreeNodeSearch(int key) {
        this.key = key;
    }

    public TreeNodeSearch(int key,T value) {
        this.value = value;
        this.key = key;
    }

    public TreeNodeSearch(TreeNodeSearch<T> left, TreeNodeSearch<T> right, T value, int key) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.key = key;
    }


    @Override
    public String toString() {
        return "TreeNodeSearch{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                ", key=" + key +
                '}';
    }
}
