package Stack_Queue;

public abstract class Animal {
    private int order;     // arrival order
    protected String name; // optional, for printing

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }
}
