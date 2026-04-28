
public class Queue {

    private Object[] data;
    private int size;

    public Queue() {
        this.size = 0;
    }

    public Queue(Object[] data) {
        this.data = data;
        this.size = data.length;
    }

    public void enQueue(Object value) {
        Object[] tempData = new Object[this.size + 1];

        System.arraycopy(this.data, 0, tempData, 0, this.size);

        tempData[this.size] = value;
        this.data = tempData;
        ++this.size;
    }

    public Object DeQueue(Object value) {
        Object tempValue = this.data[0];
        Object[] tempData = new Object[this.size - 1];

        for (int i = 0; i < this.size - 1; i++) {

            tempData[i] = this.data[i + 1];

        }

        this.data = tempData;
        --this.size;
        return tempValue;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public Object getValueAt(int index) throws Exception {
        if (index < 0 || index >= this.size) {

            throw new Exception("Index out of bounds!");

        }

        return this.data[index];
    }

    public Object[] getValuesArray() {
        return this.data.clone();
    }
}
