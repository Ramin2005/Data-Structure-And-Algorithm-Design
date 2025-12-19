
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

    public Object popLast() {

        if (isEmpty()) {

            throw new RuntimeException("List is empty!");

        }

        Object out;

        if (this.size == 1) {

            out = this.head.getValue();
            this.head = this.last = null;
            --this.size;

        } else {

            Node tempBefore = this.head;
            Node temp = this.head;

            while (temp.hasNext()) {

                tempBefore = temp;
                temp = temp.getNext();

            }

            this.last = tempBefore;
            out = temp.getValue();
            --this.size;

        }

        return out;
    }

    public Object pop(int n) {

        if (isEmpty()) {

            throw new RuntimeException("List is empty!");

        }

        if (n >= this.size) {

            throw new RuntimeException("Index out of bounds!");

        }

        Object out;

        if (this.size == 1) {

            out = this.head.getValue();
            this.head = this.last = null;
            --this.size;

        } else {
            Node temp = this.head;

            for (int i = 1; i < n + 1; i++) {

                temp = temp.getNext();

            }

            out = temp.getValue();
        }

        return out;
    }

    public boolean isEmpty() {

        return this.size < 1;

    }

}
