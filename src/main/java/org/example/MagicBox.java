package org.example;

import java.util.Random;

public class MagicBox<T> {
    public int numberAndString;
    protected T[] items;
    public int count;


    public MagicBox(int numberAndString) {
        this.numberAndString = numberAndString;
        items = (T[]) new Object[numberAndString];
    }

    public boolean add(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                count++;
                return true;
            }
        }
        return false;
    }

    public T pick() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                throw new RuntimeException("Коробка не полна и осталось ещё: " +
                        (items.length - count) + " места.");
            }
        }

        Random random = new Random();

        int randomInt = random.nextInt(3);

        return items[randomInt];
    }
}
