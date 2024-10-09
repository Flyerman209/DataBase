package org.example;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Add addBook = new Add();
        Delete deleteBook = new Delete();
        ReadDescription readDescription = new ReadDescription();
        String input;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Что вы хотите сделать? (добавить/удалить/читать/выход)");
            input = scanner.nextLine();
            switch (input) {
                case "добавить":
                    System.out.println("Введите название, автора и год издания (через пробел): ");
                    String[] addInput = scanner.nextLine().split(" ");
                    if (addInput.length == 3) {
                        addBook.main(addInput);
                    } else {
                        System.out.println("Неверный формат. Введите название, автора и год издания.");
                    }
                    break;
                case "удалить":
                    System.out.println("Введите ID книги для удаления: ");
                    String[] deleteInput = {scanner.nextLine()};
                    deleteBook.main(deleteInput);
                    break;
                case "читать":
                    System.out.println("Введите ID книги для просмотра: ");
                    String[] readInput = {scanner.nextLine()};
                    readDescription.main(readInput);
                    break;
                case "выход":
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неизвестная команда. Попробуйте снова.");
                    break;
            }
        } while (!input.equals("выход"));
        scanner.close();
    }
}
