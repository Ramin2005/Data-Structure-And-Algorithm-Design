

public class CircularQueue {

    private Object[] data;
    private final int size;

    private int f = -1;
    private int r = -1;

    public CircularQueue(int size) {
        this.size = size;
        this.data = new Object[size];
    }

    public boolean isEmpty() {
        return this.f == -1;
    }

    public boolean isFull() {
        return this.f == (this.r % this.size);
    }

    public void enQueue(Object value) throws Exception {
        if (isFull()) {
            throw new RuntimeException("Queue is full!");
        }

        if (isEmpty()) {
            this.f = 0;
        }

        this.r = (this.r + 1) % this.size;
        this.data[this.r] = value;
    }

    public Object deQueue() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        Object temp = this.data[this.f];

        if (this.f == this.r) {
            this.f = -1;
            this.r = -1;
        } else {
            this.f = (this.f + 1) % size;
        }
        
        return temp;
    }
}
