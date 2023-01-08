package org.example;

public class Main {

    public static void main(String[] args) {

        MagicBox<Integer> boxInt = new MagicBox<>(3);
        boxInt.add(1);
        boxInt.add(2);
        boxInt.add(3);

        System.out.println("Случайное число: " + boxInt.pick());

        MagicBox<String> boxString = new MagicBox<>(3);
        boxString.add("Один");
        boxString.add("Два");
        boxString.add("Три");

        System.out.println("Случайная строка: " + boxString.pick());

    }
}