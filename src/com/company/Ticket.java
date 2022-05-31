package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ticket {
    private int sitNumber;
    private int carriageNumber;
    private int trainNumber;
    private String arrivalTime;
    private String departureTime;

    public Ticket(int sit, int carriage, int train, String arrivalTime, String departureTime) {
        setSitNumber(sit);
        setCarriageNumber(carriage);
        setTrainNumber(train);
        setArrivalTime(arrivalTime);
        setDepartureTime(departureTime);
    }

    public Ticket(String document) throws IOException {
        File file1 = new File(document);
        Scanner scanner = new Scanner(file1);
        FileReader reader = new FileReader(document);
        setSitNumber(Integer.parseInt(scanner.nextLine()));
        setCarriageNumber(Integer.parseInt(scanner.nextLine()));
        setTrainNumber(Integer.parseInt(scanner.nextLine()));
        setArrivalTime(scanner.nextLine());
        setDepartureTime(scanner.nextLine());
        reader.close();
    }


    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public void setSitNumber(int sitNumber) {
        this.sitNumber = sitNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getSitNumber() {
        return sitNumber;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Ticket:" +
                "\n- Your sit number is " + sitNumber +
                ";\n- Your carriage number is " + carriageNumber +
                ";\n- Your train number is " + trainNumber +
                ";\n- Time and date of arrival: " + arrivalTime +
                ";\n- Time and date of departure: " + departureTime +
                '.';
    }
}
