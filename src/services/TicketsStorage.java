package services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.tickets.Tickets;

public class TicketsStorage {

    private static final String FILE_NAME = "tickets.txt";

    public static void saveTickets(List<Tickets> tickets) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        out.writeObject(tickets);
        out.close();
    }

    public static List<Tickets> loadTickets() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            List<Tickets> list = (List<Tickets>) in.readObject();
            in.close();
            return list;
        } catch (Exception e) {
            return new ArrayList<>(); //
        }
    }
}
