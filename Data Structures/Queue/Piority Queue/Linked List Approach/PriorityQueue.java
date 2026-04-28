public class PriorityQueue {

    private CustomNode data;
    private CustomNode lastValue;
    private int size;

    private int minPriorityIndex = -1;
    private int minPriority = 2147483646;

    private int maxPriorityIndex = -1;
    private int maxPriority = -2147483648;

    public PriorityQueue() {
        this.size = 0;
    }

    public PriorityQueue(CustomNode data) {
        this.data = data;

        CustomNode temp = data;

        int index = 0;
        int tempPriority;

        if (temp.getValue() != null) {

            this.lastValue = temp;

            ++index;

            this.minPriorityIndex = index;
            this.minPriority = temp.getValuePriority();

            this.maxPriorityIndex = index;
            this.maxPriority = temp.getValuePriority();
        }

        while (temp.hasNextNode()) {

            ++index;

            temp = temp.getNextNode();
            this.lastValue = temp;

            tempPriority = temp.getValuePriority();

            if (tempPriority > this.maxPriority) {

                this.maxPriority = tempPriority;
                this.maxPriorityIndex = index;

            } else if (tempPriority < this.minPriority) {

                this.minPriority = tempPriority;
                this.minPriorityIndex = index;

            }

        }

        this.size = index;

    }

    // EnQueue Method:
    public void enQueue(Object value, int priority) {
        CustomNode temp = new CustomNode(value, priority);

        if (this.size == 0) {

            this.data = temp;
            this.lastValue = this.data;

        } else {

            this.lastValue.setNextNode(temp);
            this.lastValue = lastValue.getNextNode();

        }

        ++this.size;

        if (priority > this.maxPriority) {

            this.maxPriority = priority;
            this.maxPriorityIndex = this.size;

        } else if (priority < this.minPriority) {

            this.minPriority = priority;
            this.minPriorityIndex = this.size;

        }

    }

    // DeQueue methods:
    public Object normalDeQueue() {

        if (this.size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        Object out;
        int priority;

        out = this.data.getValue();
        priority = this.data.getValuePriority();

        this.data = this.data.getNextNode();
        --this.size;

        if (priority == this.maxPriority || priority == this.minPriority) {

            CustomNode temp = data;

            int index = 0;
            int tempPriority;

            if (temp.getValue() != null) {
                ++index;

                this.minPriorityIndex = index;
                this.minPriority = temp.getValuePriority();

                this.maxPriorityIndex = index;
                this.maxPriority = temp.getValuePriority();
            }

            while (temp.hasNextNode()) {

                ++index;

                temp = temp.getNextNode();

                tempPriority = temp.getValuePriority();

                if (tempPriority > this.maxPriority) {

                    this.maxPriority = tempPriority;
                    this.maxPriorityIndex = index;

                } else if (tempPriority < this.minPriority) {

                    this.minPriority = tempPriority;
                    this.minPriorityIndex = index;

                }

            }

        }

        return out;

    }

    public Object maxPriorityDeQueue() {

        if (this.size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        Object out = null;

        CustomNode beforeTemp = null;
        CustomNode nextTemp = this.data;

        while (out == null && nextTemp != null) {

            if (nextTemp.getValuePriority() == this.maxPriority) {

                out = nextTemp.getValue();
                beforeTemp.setNextNode(nextTemp.getNextNode());
                --this.size;

                CustomNode temp = this.data;

                int index = 0;
                int tempPriority;

                if (temp.getValue() != null) {

                    this.lastValue = temp;

                    ++index;

                    this.minPriorityIndex = index;
                    this.minPriority = temp.getValuePriority();

                    this.maxPriorityIndex = index;
                    this.maxPriority = temp.getValuePriority();
                }

                while (temp.hasNextNode()) {

                    ++index;

                    temp = temp.getNextNode();
                    this.lastValue = temp;

                    tempPriority = temp.getValuePriority();

                    if (tempPriority > this.maxPriority) {

                        this.maxPriority = tempPriority;
                        this.maxPriorityIndex = index;

                    } else if (tempPriority < this.minPriority) {

                        this.minPriority = tempPriority;
                        this.minPriorityIndex = index;

                    }

                }

                if (index != this.size) {

                    throw new RuntimeException("Queue is Damaged!");

                }

            }

            beforeTemp = nextTemp;
            if (nextTemp.hasNextNode()) {

                nextTemp = nextTemp.getNextNode();

            } else {

                nextTemp = null;

            }

        }

        if (out == null) {

            throw new RuntimeException("Queue is Damaged!");

        }

        return out;

    }

    public Object minPriorityDeQueue() {

        if (this.size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        Object out = null;

        CustomNode beforeTemp = null;
        CustomNode nextTemp = this.data;

        while (out == null && nextTemp != null) {

            if (nextTemp.getValuePriority() == this.minPriority) {

                out = nextTemp.getValue();
                beforeTemp.setNextNode(nextTemp.getNextNode());
                --this.size;

                CustomNode temp = this.data;

                int index = 0;
                int tempPriority;

                if (temp.getValue() != null) {

                    this.lastValue = temp;

                    ++index;

                    this.minPriorityIndex = index;
                    this.minPriority = temp.getValuePriority();

                    this.maxPriorityIndex = index;
                    this.maxPriority = temp.getValuePriority();

                }

                while (temp.hasNextNode()) {

                    ++index;

                    temp = temp.getNextNode();
                    this.lastValue = temp;

                    tempPriority = temp.getValuePriority();

                    if (tempPriority > this.maxPriority) {

                        this.maxPriority = tempPriority;
                        this.maxPriorityIndex = index;

                    } else if (tempPriority < this.minPriority) {

                        this.minPriority = tempPriority;
                        this.minPriorityIndex = index;

                    }

                }

                if (index != this.size) {

                    throw new RuntimeException("Queue is Damaged!");

                }

            }

            beforeTemp = nextTemp;
            if (nextTemp.hasNextNode()) {

                nextTemp = nextTemp.getNextNode();

            } else {

                nextTemp = null;

            }

        }

        if (out == null) {

            throw new RuntimeException("Queue is Damaged!");

        }

        return out;

    }

    // set methods
    public void setAllAt(Object value, int priority, int index) {
        if (index < 1 || index > this.size) {
            throw new RuntimeException("Index out of bounds!");
        }

        CustomNode temp = this.data;
        for (int i = 1; i < index; i++) {

            temp = temp.getNextNode();

            if (temp == null) {

                throw new RuntimeException("Queue is Damaged!");

            }

        }

        if (priority > this.maxPriority) {

            this.maxPriority = priority;
            this.maxPriorityIndex = index;

        } else if (priority < this.minPriority) {

            this.minPriority = priority;
            this.minPriorityIndex = index;

        }

        temp.setValue(value);
        temp.setPriority(priority);
    }

    public void setValueAt(Object value, int index) {
        if (index < 1 || index > this.size) {
            throw new RuntimeException("Index out of bounds!");
        }

        CustomNode temp = this.data;
        for (int i = 1; i < index; i++) {

            temp = temp.getNextNode();

            if (temp == null) {

                throw new RuntimeException("Queue is Damaged!");

            }

        }

        temp.setValue(value);
    }

    public void setValuePriorityAt(int priority, int index) {
        if (index < 1 || index > this.size) {
            throw new RuntimeException("Index out of bounds!");
        }

        CustomNode temp = this.data;
        for (int i = 1; i < index; i++) {

            temp = temp.getNextNode();

            if (temp == null) {

                throw new RuntimeException("Queue is Damaged!");

            }

        }

        if (priority > this.maxPriority) {

            this.maxPriority = priority;
            this.maxPriorityIndex = index;

        } else if (priority < this.minPriority) {

            this.minPriority = priority;
            this.minPriorityIndex = index;

        }

        temp.setPriority(priority);
    }

    //  get methods
    public int getSize() {
        return this.size;
    }

    public int getMaxPriority() {
        return this.maxPriority;
    }

    public int getMinPriority() {
        return this.minPriority;
    }

    public int getMaxPriorityIndex() {
        return this.maxPriorityIndex;
    }

    public int getMinPriorityIndex() {
        return this.minPriorityIndex;
    }

    public Object getMaxPriorityValue() {

        if (this.size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        Object out = null;

        CustomNode Temp = this.data;

        while (out == null && Temp != null) {

            if (Temp.getValuePriority() == this.maxPriority) {

                out = Temp.getValue();
            }

            if (Temp.hasNextNode()) {

                Temp = Temp.getNextNode();

            } else {

                Temp = null;

            }

        }

        if (out == null) {

            throw new RuntimeException("Queue is Damaged!");

        }

        return out;

    }

    public Object getMinPriorityValue() {

        if (this.size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        Object out = null;

        CustomNode Temp = this.data;

        while (out == null && Temp != null) {

            if (Temp.getValuePriority() == this.minPriority) {

                out = Temp.getValue();
            }

            if (Temp.hasNextNode()) {

                Temp = Temp.getNextNode();

            } else {

                Temp = null;

            }

        }

        if (out == null) {

            throw new RuntimeException("Queue is Damaged!");

        }

        return out;

    }

    // boolean methods:
    public boolean isEmpty() {
        return (this.size == 0);
    }
}
