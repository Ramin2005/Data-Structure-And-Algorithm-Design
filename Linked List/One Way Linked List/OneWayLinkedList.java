
public class OneWayLinkedList {

    private Node head = null;
    private Node last = null;
    private int size = 0;

    public OneWayLinkedList() {

    }

    public OneWayLinkedList(Object[] values) {

        for (Object value : values) {

            Node temp = new Node(value);

            if (this.size < 1) {

                this.head = temp;
                this.last = temp;
                ++this.size;

            } else {

                this.last.setNext(temp);
                this.last = temp;
                ++this.size;

            }

        }

    }

    public void add(Object value) {

        Node temp = new Node(value);

        if (this.size < 1) {

            this.head = temp;
            this.last = temp;
            ++this.size;

        } else {

            this.last.setNext(temp);
            this.last = temp;
            ++this.size;

        }

    }

    public boolean isEmpty() {

        return this.size < 1;

    }

}
