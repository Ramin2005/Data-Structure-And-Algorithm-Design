
/**
 * This link list customized to stores priority value for each value and any value type.
 */
public class CustomLinkList {

    private Object value;
    private int priority;
    private CustomLinkList next;

    public CustomLinkList() {

    }

    public CustomLinkList(Object value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public CustomLinkList(int value[], int priority, CustomLinkList next) {
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

    public CustomLinkList getNextNode() {
        return this.next;
    }

    public void setNextNode(CustomLinkList newNext) {
        this.next = newNext;
    }

}
