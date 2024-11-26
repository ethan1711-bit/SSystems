package ss.hotel;

public class Room {
    private int number;
    private Guest guest;
    private Safe safe;

    /**
     * Creates a Room with the given number and a new Safe.
     * @param number the number of the new Room
     */
    public Room(int number) {
    	this(number, new Safe());
    }
    /**
     * Creates a Room with the given number and Safe.
     * @param number the number of the new Room
     * @param safe the Safe for the new Room
     */
    public Room(int number, Safe safe){
        this.number = number;
        this.safe = safe;
    }


    /**
     * Returns the number of this Room
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the current guest living in this Room
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
        return guest;
    }

    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {
    	this.guest = guest;
    }

    /**
     * Returns the Safe in this Room.
     * @return the Safe in this Room
     */
    public Safe getSafe() {
        return safe;
    }
    @Override
    public String toString(){
        return "Room " + number;
    }
}
