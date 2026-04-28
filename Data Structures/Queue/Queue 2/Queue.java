
public class Queue {

    private Node data;
    private Node lastNode;
    private int size;

    public Queue() {
        this.size = 0;
    }

    public void enQueue(Object value) {

        if (this.size == 0) {

            this.data = new Node(value);
            this.lastNode = this.data;
            ++this.size;

        } else {

            this.lastNode.setNextNode(new Node(value));
            this.lastNode = this.lastNode.getNextNode();
            ++this.size;

        }

    }

    public Object deQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is Empty1");
        }

        Object temp = this.data.getValue();

        this.data = this.data.getNextNode();
        --this.size;

        return temp;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int Size() {
        return size;
    }

    public class Node {

        private Object value;
        private Node nextNode = null;

        public Node() {

        }

        public Node(Object value) {
            this.value = value;
        }

        public Node(Object value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public Object getValue() {
            return value;
        }

        public boolean hasNextNode() {
            return this.nextNode != null;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

    }

}
