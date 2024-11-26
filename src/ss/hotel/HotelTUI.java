package ss.hotel;

import java.util.Scanner;

public class HotelTUI {
    private static final String IN = "in";
    private static final String OUT = "out";
    private static final String ROOM = "room";
    private static final String ACTIVATE = "activate";
    private static final String PRINT = "print";
    private static final String HELP = "help";
    private static final String EXIT = "exit";

    private Hotel hotel;

    public HotelTUI(Hotel hotel) {
        this.hotel = hotel;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean exit = false;

        showMenu();

        while (!exit) {
            System.out.print("Command: ");
            line = scanner.nextLine().trim();

            if (line.isEmpty()) continue;

            String[] split = line.split(" ", 2);
            String command = split[0];
            String param = (split.length > 1) ? split[1] : null;

            switch (command) {
                case IN:
                    if (param == null) {
                        System.out.println("Error: Please provide a guest name for check-in.");
                    } else {
                        doIn(param);
                    }
                    break;

                case OUT:
                    if (param == null) {
                        System.out.println("Error: Please provide a guest name for check-out.");
                    } else {
                        doOut(param);
                    }
                    break;

                case ROOM:
                    if (param == null) {
                        System.out.println("Error: Please provide a guest name to check the room.");
                    } else {
                        doRoom(param);
                    }
                    break;

                case ACTIVATE:
                    if (param == null) {
                        System.out.println("Error: Please provide a guest name to activate the safe.");
                    } else {
                        doActivate(param);
                    }
                    break;

                case PRINT:
                    doPrint();
                    break;

                case HELP:
                    showMenu();
                    break;

                case EXIT:
                    exit = true;
                    System.out.println("Exiting Hotel Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Unknown command! Type 'help' for a list of commands.");
            }
        }

        scanner.close();
    }

    private void showMenu() {
        System.out.println("Commands:");
        System.out.println(IN + " name .......... Check in guest with name");
        System.out.println(OUT + " name .......... Check out guest with name");
        System.out.println(ROOM + " name .......... Show room of guest with name");
        System.out.println(ACTIVATE + " name ......... Activate safe for guest with name");
        System.out.println(PRINT + " ............... Print the hotel state");
        System.out.println(HELP + " ............... Show this help menu");
        System.out.println(EXIT + " ............... Exit the system");
    }

    private void doIn(String name) {
        Room room = hotel.checkIn(name);
        if (room != null) {
            System.out.println("Guest " + name + " gets room " + room.getNumber());
        } else {
            System.out.println("No available rooms. Check-in failed for " + name);
        }
    }

    private void doOut(String name) {
        boolean success = hotel.checkOut(name);
        if (success) {
            System.out.println("Guest " + name + " successfully checked out.");
        } else {
            System.out.println("No such guest checked in. Check-out failed for " + name);
        }
    }

    private void doRoom(String name) {
        Room room = hotel.getRoom(name);
        if (room != null) {
            System.out.println("Guest " + name + " has room " + room.getNumber());
        } else {
            System.out.println("Guest " + name + " is not checked in.");
        }
    }

    private void doActivate(String name) {
        Room room = hotel.getRoom(name);
        if (room != null) {
            Safe safe = room.getSafe();
            safe.activate();
            System.out.println("Safe of guest " + name + " is now activated.");
        } else {
            System.out.println("Guest " + name + " is not checked in. Safe activation failed.");
        }
    }

    private void doPrint() {
        System.out.println(hotel);
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Twente");
        HotelTUI tui = new HotelTUI(hotel);
        tui.run();
    }
}