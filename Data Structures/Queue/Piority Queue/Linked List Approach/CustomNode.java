
/**
 * Customized node to stores priority value for each value and any value type.
 */
public class CustomNode {

    private Object value;
    private int priority;
    private CustomNode next;

    public CustomNode() {

    }

    public CustomNode(Object value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public CustomNode(int value[], int priority, CustomNode next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object newValue) {
        this.value = newValue;
    }

    public int getValuePriority() {
        return this.priority;
    }

    public void setPriority(int newPriority) {
        this.priority = newPriority;
    }

    public boolean hasNextNode() {
        return (this.next != null);
    }

    public CustomNode getNextNode() {
        return this.next;
    }

    public void setNextNode(CustomNode newNext) {
        this.next = newNext;
    }

}
