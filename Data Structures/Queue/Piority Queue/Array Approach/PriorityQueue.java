
public class PriorityQueue {

    private Object[] data;
    private int[] priorities;
    private int size;

    private int minPriorityIndex = -1;
    private int minPriority = 2147483646;
    private Object minPriorityValue = null;

    private int maxPriorityIndex = -1;
    private int maxPriority = -2147483648;
    private Object maxPriorityValue = null;

    public PriorityQueue() {

        this.size = 0;

    }

    public PriorityQueue(Object[] data, int[] priorities) {
        if (data.length != priorities.length) {

            throw new RuntimeException("Data and priority lists must be the same length!");

        }

        this.data = data;
        this.priorities = priorities;
        this.size = data.length;

        for (int i = 0; i < this.size; i++) {

            if (this.priorities[i] > this.maxPriority) {

                this.maxPriority = priorities[i];
                this.maxPriorityIndex = i;
                this.maxPriorityValue = data[i];

            } else if (this.priorities[i] < this.minPriority) {

                this.minPriority = priorities[i];
                this.minPriorityIndex = i;
                this.minPriorityValue = data[i];

            }

        }

    }

    public void enQueue(Object value, int priority) {

        Object[] tempData = new Object[this.size + 1];
        int[] tempPriorities = new int[this.size + 1];

        for (int i = 0; i < this.size; i++) {

            tempData[i] = this.data[i];
            tempPriorities[i] = this.priorities[i];

        }

        tempData[this.size] = value;
        tempPriorities[this.size] = priority;
        ++this.size;

        if (priority > this.maxPriority) {

            this.maxPriority = priority;
            this.maxPriorityIndex = this.size;
            this.maxPriorityValue = value;

        } else if (priority < this.minPriority) {

            this.minPriority = priority;
            this.minPriorityIndex = this.size;
            this.minPriorityValue = value;

        }

    }

    public Object normalDeQueue() {
        Object tempValue = this.data[0];

        Object[] tempData = new Object[this.size - 1];
        int[] tempPriorities = new int[this.size - 1];

        for (int i = 0; i < this.size - 1; i++) {

            Object value = this.data[i + 1];
            int priority = this.priorities[i + 1];

            tempData[i] = value;
            tempPriorities[i] = priority;

            if (priority > this.maxPriority) {

                this.maxPriority = priority;
                this.maxPriorityIndex = i;
                this.maxPriorityValue = value;

            } else if (priority < this.minPriority) {

                this.minPriority = priority;
                this.minPriorityIndex = i;
                this.minPriorityValue = value;

            }
        }

        this.data = tempData;
        this.priorities = tempPriorities;
        --this.size;

        return tempValue;
    }

    public Object MaxPriorityDeQueue() {
        Object tempValue = this.data[this.maxPriorityIndex];

        Object[] tempData = new Object[this.size - 1];
        int[] tempPriorities = new int[this.size - 1];

        for (int i = 0; i < this.maxPriorityIndex; i++) {

            Object value = this.data[i];
            int priority = this.priorities[i];

            tempData[i] = value;
            tempPriorities[i] = priority;

            if (priority > this.maxPriority) {

                this.maxPriority = priority;
                this.maxPriorityIndex = i;
                this.maxPriorityValue = value;

            } else if (priority < this.minPriority) {

                this.minPriority = priority;
                this.minPriorityIndex = i;
                this.minPriorityValue = value;

            }
        }

        for (int i = this.maxPriority; i < this.size - 1; i++) {

            Object value = this.data[i + 1];
            int priority = this.priorities[i + 1];

            tempData[i] = value;
            tempPriorities[i] = priority;

            if (priority > this.maxPriority) {

                this.maxPriority = priority;
                this.maxPriorityIndex = i;
                this.maxPriorityValue = value;

            } else if (priority < this.minPriority) {

                this.minPriority = priority;
                this.minPriorityIndex = i;
                this.minPriorityValue = value;

            }
        }

        this.data = tempData;
        this.priorities = tempPriorities;
        --this.size;

        return tempValue;
    }

    public Object MinPriorityDeQueue() {
        Object tempValue = this.data[this.minPriorityIndex];

        Object[] tempData = new Object[this.size - 1];
        int[] tempPriorities = new int[this.size - 1];

        for (int i = 0; i < this.minPriorityIndex; i++) {

            Object value = this.data[i];
            int priority = this.priorities[i];

            tempData[i] = value;
            tempPriorities[i] = priority;

            if (priority > this.maxPriority) {

                this.maxPriority = priority;
                this.maxPriorityIndex = i;
                this.maxPriorityValue = value;

            } else if (priority < this.minPriority) {

                this.minPriority = priority;
                this.minPriorityIndex = i;
                this.minPriorityValue = value;

            }
        }

        for (int i = this.minPriority; i < this.size - 1; i++) {

            Object value = this.data[i + 1];
            int priority = this.priorities[i + 1];

            tempData[i] = value;
            tempPriorities[i] = priority;

            if (priority > this.maxPriority) {

                this.maxPriority = priority;
                this.maxPriorityIndex = i;
                this.maxPriorityValue = value;

            } else if (priority < this.minPriority) {

                this.minPriority = priority;
                this.minPriorityIndex = i;
                this.minPriorityValue = value;

            }
        }

        this.data = tempData;
        this.priorities = tempPriorities;
        --this.size;

        return tempValue;
    }

    public int getMinPriorityIndex() {
        return minPriorityIndex;
    }

    public int getMaxPriorityIndex() {
        return maxPriorityIndex;
    }

    public Object getMinPriorityValue() {
        return minPriorityValue;
    }

    public Object getMaxPriorityValue() {
        return maxPriorityValue;
    }
}
