package com.company;

import java.util.ArrayList;

public class Tickets {
    ArrayList<Ticket> ticketsList = new ArrayList<>();

    public void addTicketToList(Ticket ticket) {
        ticketsList.add(ticket);
    }

    public void printTicketsList() {
        if (ticketsList.isEmpty()){
            System.out.println("It is empty!!!");
        } else {
            for (Ticket ticket : ticketsList) {
                System.out.println(ticketsList.indexOf(ticket) + " - " + ticket.toString());
            }
        }
    }
}
