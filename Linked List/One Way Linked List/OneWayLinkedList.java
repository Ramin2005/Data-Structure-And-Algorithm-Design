
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

    /**
     *
     * Add value to end of link list
     *
     * - complexity order: O(n)
     *
     * @param value
     *
     */
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

    /**
     *
     * Add new value to target index
     *
     * - complexity order: O(n)
     *
     * @param value
     * @param index
     */
    public void insert(Object value, int index) {

        if (index < 0) {

            throw new RuntimeException("Invalid index!");

        }

        if (index > this.size) {

            throw new RuntimeException("Index out of bounds!");

        }

        Node temp1 = new Node(value);

        if (index == 0) {
            temp1.setNext(this.head);
            this.head = temp1;
        } else {

            Node temp2 = this.head;
            Node temp3 = this.head;

            for (int i = 0; i < index; i++) {
                temp2 = temp3;
                temp3 = temp3.getNext();
            }

            temp1.setNext(temp3);
            temp2.setNext(temp1);

        }

    }

    /**
     * Return value of target index
     *
     * - complexity order: O(n)
     *
     * @param index
     * @return
     */
    public Object getObjectAt(int index) {

        if (index < 0) {

            throw new RuntimeException("Invalid index!");

        }

        if (index >= this.size) {

            throw new RuntimeException("Index out of bounds!");

        }

        Object out;

        Node temp = this.head;

        for (int i = 0; i < index; i++) {

            temp = temp.getNext();

        }

        out = temp.getValue();

        return out;
    }

    /**
     *
     * return pop head node value
     *
     * - complexity order: O(1)
     *
     * @throws Runtime Exception if list is empty
     * @return Head Node value
     */
    public Object pop() {

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

    /**
     *
     * return pop last node value
     *
     * - complexity order: O(n)
     *
     * @throws Runtime Exception if list is empty
     * @return Last Node value
     */
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

    public boolean isEmpty() {

        return this.size < 1;

    }

}
