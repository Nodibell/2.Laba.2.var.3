package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Варіант 3. Клас «Проїздний квиток»
До закритих даних членів добавити:
- дату та час відбуття;
- дату та час прибуття;
До відкритих методів добавити:
- функцію яка повертає дату та час прибуття;
- функцію яка повертає дату та час відбуття.
Створити два конструктори, які будуть зчитувати дані для полів класу з
текстового файлу. Перший конструктор без параметрів. В другий конструктор через
параметр зчитується назва текстового файлу.
Деструктор має виводити на екран вміст обєкту типу «Проїздний квиток».
Приклад текстового файлу (pk.txt):
21
7
101
8 1 2009 10 45
9 1 2009 9 10
*/

public class Main {
    static Scanner scanner = new Scanner(System.in);

    //checker on minus numbers or 0
    public static boolean isValid(int numberToCheck) {
        if (numberToCheck <= 0) {
            System.out.println("Number of the sit can't equal 0 or be lower! Reenter the number please.");
            return false;
        } else {
            return true;
        }
    }

    public static int addNumberOf(String whatToAdd) {
        int numberToAdd;
        while (true) {
            try {
                System.out.print("Insert your " + whatToAdd + " number: ");
                numberToAdd = scanner.nextInt();
                if (isValid(numberToAdd)) {
                    return numberToAdd;
                }

            } catch (InputMismatchException e) {
                System.out.println("Incorrect symbol! Reenter the number please.");
                scanner = new Scanner(System.in);
            }
        }
    }

    public static String addTimeAndDateOf(String whatToAdd) {
        String timeAndDate = "";
        String i;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Insert the time of " + whatToAdd + ": ");
            i = scanner.nextLine();
            if ((i.matches("^[0-2]?[0-9][:][0-5][0-9]$")) && (!(i.matches("^[0-2][4-9][:][0-6][0-9]$")))) {
                timeAndDate += i;
                break;
            } else {
                System.out.print("Incorrect time of " + whatToAdd + ". Reenter the time, please!\n");
            }
        }

        while (true) {
            System.out.print("Insert the date of " + whatToAdd + ": ");
            i = scanner.nextLine();
            if ((i.matches("^[0-3]?[0-9][.][0-1]?[0-9][.][0-9]{1,}$")) &&
                    (!(i.matches("^[3][2-9][.][0-1]?[0-9][.][0-9]{1,}$"))) &&
                    (!(i.matches("^[0]?[0][.][0]?[0][.][0-9]{1,}$"))) &&
                    (!(i.matches("^[0]?[0][.][0]?[0][.][0-9]{1,}$"))) &&
                    (!(i.matches("^[0-3]?[0-9][.][1-9][3-9][.][0-9]{1,}$")))) {
                timeAndDate += (" " + i);
                break;
            } else {
                System.out.print("Incorrect date of " + whatToAdd + ". Reenter the time, please!\n");
            }
        }
        return timeAndDate;
    }

    public static void main(String[] args) throws IOException {
        Tickets tickets = new Tickets();
        int sit;
        int carriage;
        int train;
        int action;
        String arrival;
        String departure;
        String fileName;

        //adding new ticket
        while (true) {
            System.out.print("===========><&\n" +
                    "Actions:\n" +
                    "0 - exit\n" +
                    "1 - add new Ticket through console\n" +
                    "2 - add new Ticket to a new \"fileName\".txt \n" +
                    "3 - add new Ticket from existing \"fileName\".txt to list\n" +
                    "4 - print the list of tickets\n" +
                    "What to do: ");
            action = scanner.nextInt();
            switch (action) {
                case 0:
                    return;
                case 1:
                    sit = addNumberOf("sit");
                    carriage = addNumberOf("carriage");
                    train = addNumberOf("train");
                    arrival = addTimeAndDateOf("arrival");
                    departure = addTimeAndDateOf("departure");
                    Ticket ticket = new Ticket(sit, carriage, train, arrival, departure);
                    tickets.addTicketToList(ticket);
                    System.out.println("Your ticket successfully created!");
                    System.out.println("~~~~~~~~~~*\n" +
                            ticket.toString());
                    break;

                case 2:
                        System.out.print("Enter the name of a new file: ");
                        fileName = scanner.next();
                        File file1 = new File(fileName + ".txt");
                        file1.createNewFile();
                        FileWriter writer = new FileWriter(file1);

                        sit = addNumberOf("sit");
                        carriage = addNumberOf("carriage");
                        train = addNumberOf("train");
                        arrival = addTimeAndDateOf("arrival");
                        departure = addTimeAndDateOf("departure");

                        writer.write(sit + "\n" + carriage + "\n" + train + "\n" + arrival + "\n" + departure);
                        writer.flush();
                        writer.close();
                        break;


                case 3:
                    try {
                    System.out.print("Enter the name of the existing file: ");
                    fileName = scanner.next();
                    Ticket ticket2 = new Ticket(fileName + ".txt");
                    System.out.println("This ticket was successfully added.");
                    tickets.addTicketToList(ticket2);
                    break;
                    } catch (FileNotFoundException e){
                        System.out.println("This file doesn't exist");
                    }

                case 4:
                   tickets.printTicketsList();
                   break;

                default:
                    System.out.println("There is no such an action!!!");
            }
        }
    }
}