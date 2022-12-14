package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Book 1", 245);
        Book book2 = new Book("Book 2", 123);
        Book book3 = new Book("Book 3", 14);
        Book cleanCode = new Book("Clean Code", 666);
        Book[] array = new Book[4];
        array[0] = book1;
        array[1] = book2;
        array[2] = book3;
        array[3] = cleanCode;
        for (Book bk : array) {
            System.out.println(bk.getTitle() + ", " + bk.getPages());
        }
        array[0] = cleanCode;
        array[3] = book1;
        for (Book bk : array) {
            if ("Clean Code".equals(bk.getTitle())) {
                System.out.println(bk.getTitle() + ", " + bk.getPages());
            }
        }
    }
}