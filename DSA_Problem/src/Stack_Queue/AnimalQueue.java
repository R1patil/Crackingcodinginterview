package Stack_Queue;

import java.util.LinkedList;

public class AnimalQueue {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // keeps track of arrival time

    // Enqueue any animal
    public void enqueue(Animal animal) {
        animal.setOrder(order++);  // assign current order, then increment

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    // Dequeue any: the oldest between front dog and cat
    public Animal dequeueAny() {
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        return dogs.poll(); // poll removes from front or returns null
    }

    public Cat dequeueCat() {
        return cats.poll();
    }


    public static void main(String[] args) {
        AnimalQueue shelter = new AnimalQueue();

        shelter.enqueue(new Dog("Bruno"));
        shelter.enqueue(new Cat("Whiskers"));
        shelter.enqueue(new Dog("Rex"));
        shelter.enqueue(new Cat("Luna"));

        System.out.println("Adopted: " + shelter.dequeueAny().name); // Bruno
        System.out.println("Adopted: " + shelter.dequeueCat().name); // Whiskers
        System.out.println("Adopted: " + shelter.dequeueDog().name); // Rex
        System.out.println("Adopted: " + shelter.dequeueAny().name); // Luna
    }
}
