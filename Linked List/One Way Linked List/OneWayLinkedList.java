

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

                this.head = this.last = temp;
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

            this.head = this.last = temp;
            ++this.size;

        } else {

            this.last.setNext(temp);
            this.last = temp;
            ++this.size;

        }

    }

    public Object popFirst() {

        if (isEmpty()) {

            throw new RuntimeException("List is empty!");

        }

        Object out;

        if (this.size == 1) {

            out = this.head.getValue();
            this.head = this.last = null;
            --this.size;

        } else {

            out = this.head.getValue();
            this.head = this.head.getNext();
            --this.size;

        }

        return out;
    }

    public boolean isEmpty() {

        return this.size < 1;

    }

}
